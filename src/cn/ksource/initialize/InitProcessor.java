package cn.ksource.initialize;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.module.SysModuleDto;
import cn.ksource.service.module.ModuleService;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class InitProcessor implements ApplicationListener<ContextRefreshedEvent> {

    public static final Map<String,String> allModule = new HashMap<String, String>();

    private static ModuleService sysModuleService;

    @Autowired
    public void setSysModuleService(ModuleService sysModuleService) {
        InitProcessor.sysModuleService = sysModuleService;
    }

    public static void initMenuSet() {
        log.info(" refresh system menu ");
        allModule.clear();
        for (SysModuleDto sysModuleDto : sysModuleService.findAll()) {
            //如果是一，二级菜单，则{moduleId：moduleCode}
            if(StrUtil.isBlank(sysModuleDto.getModuleUrl())){
                allModule.put(Convert.toStr(sysModuleDto.getId()), sysModuleDto.getModuleCode());
            }else{
                allModule.put(sysModuleDto.getModuleUrl(),sysModuleDto.getModuleCode());
            }
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //设置fast json解析规则
        SerializeConfig.getGlobalInstance().put(BigInteger.class, ToStringSerializer.instance);
        SerializeConfig.getGlobalInstance().put(Long.class, ToStringSerializer.instance);
        SerializeConfig.getGlobalInstance().put(Long.TYPE, ToStringSerializer.instance);
        initMenuSet();
    }



}
