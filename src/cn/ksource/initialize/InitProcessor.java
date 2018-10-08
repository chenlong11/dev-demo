package cn.ksource.initialize;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.sysModule.SysModuleDto;
import cn.ksource.service.SysModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/8/23
 * time：9:02
 */
@Component
@Slf4j
public class InitProcessor {

    @Autowired
    private SysModuleService sysModuleService;

    public static final Map<String,String> allModule = new HashMap<String, String>();

    @PostConstruct
    public void initMenuSet() {
        log.info(" refresh system menu ");
        allModule.clear();
        for (SysModuleDto sysModuleDto : sysModuleService.findAll()) {
            //如果是一，二级菜单，则{moduleId：moduleCode}
            if(StrUtil.isBlank(sysModuleDto.getModuleUrl())){
                allModule.put(sysModuleDto.getId(), sysModuleDto.getModuleCode());
            }else{
                allModule.put(sysModuleDto.getModuleUrl(),sysModuleDto.getModuleCode());
            }
        }
    }

}
