package cn.ksource.service;

import cn.hutool.core.util.RandomUtil;
import cn.ksource.domain.sysModule.SysModule;
import cn.ksource.domain.sysModule.SysModuleDto;
import cn.ksource.domain.sysModule.SysModuleExample;
import cn.ksource.initialize.InitProcessor;
import cn.ksource.mapper.sysModule.SysModuleManager;
import cn.ksource.util.TreeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:37
 */
@Service
public class SysModuleServiceImpl implements SysModuleService {

    @Autowired
    private InitProcessor initProcessor;

    @Autowired
    private SysModuleManager sysMoudleDao;

    @Override
    public List findListByUserId(String userId) {
        return sysMoudleDao.selectListByUserId(userId);
    }

    @Override
    public List<SysModuleDto> findAll() {
        List<SysModuleDto> permissions = new ArrayList<SysModuleDto>();
        List<SysModule> sysModules = sysMoudleDao.selectByExample(new SysModuleExample());
        for (SysModule sysModule : sysModules) {
            SysModuleDto sysModuleDto = new SysModuleDto();
            BeanUtils.copyProperties(sysModule,sysModuleDto);
            permissions.add(sysModuleDto);
        }
        return permissions;
    }

    @Override
    public List<SysModuleDto> findAllByStatus(Integer status) {
        return sysMoudleDao.selectAllByState(status);
    }

    @Override
    public List<Map> findModuleTree() {
        return TreeUtil.createTreeByList(findAllByStatus(1));
    }

    @Override
    public List<SysModuleDto> findListByPid(String pid) {

        return sysMoudleDao.selectListByPid(pid);
    }

    @Override
    public SysModuleDto getById(String id) {
        SysModule sysModule = sysMoudleDao.selectByPrimaryKey(id);
        SysModuleDto moduleDto = new SysModuleDto();
        BeanUtils.copyProperties(sysModule, moduleDto);
        return moduleDto;
    }

    @Override
    public String save(SysModuleDto moduleDto) {
        String id = RandomUtil.simpleUUID();
        SysModule sysModule = new SysModule();
        BeanUtils.copyProperties(moduleDto, sysModule);
        sysModule.setId(id);
        sysModule.setCreateDate(new Date());
        sysModule.setCreateDate(new Date());
        sysModule.setState(Byte.valueOf("1"));
        sysMoudleDao.insert(sysModule);
        initProcessor.initMenuSet();
        return id;
    }

    @Override
    public void update(SysModuleDto moduleDto) {
        SysModule sysModule = new SysModule();
        BeanUtils.copyProperties(moduleDto, sysModule);
        sysMoudleDao.updateByPrimaryKeySelective(sysModule);
        initProcessor.initMenuSet();
    }

    @Override
    public void deleteById(String id) {
        sysMoudleDao.deleteByPrimaryKey(id);
    }

}
