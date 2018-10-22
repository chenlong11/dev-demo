package cn.ksource.service.module;

import cn.ksource.domain.module.SysModule;
import cn.ksource.domain.module.SysModuleDto;
import cn.ksource.domain.module.SysModuleExample;
import cn.ksource.domain.org.SysOrgDto;
import cn.ksource.domain.role.SysRoleDto;
import cn.ksource.initialize.InitProcessor;
import cn.ksource.mapper.module.SysModuleManager;
import cn.ksource.service.org.OrgService;
import cn.ksource.service.role.RoleService;
import cn.ksource.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:37
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private InitProcessor initProcessor;

    @Autowired
    private SysModuleManager moduleManager;

    @Autowired
    private OrgService orgService;

    @Autowired
    private RoleService roleService;

    @Override
    public List findListByUserId(Long userId) {
        boolean flag = roleService.isSuperAdmin(userId);
        if(flag){//超级管理员可查看所有模块
            return moduleManager.selectAllByState(1);
        }else{
            return moduleManager.selectListByUserId(userId);
        }
    }

    @Override
    public List<SysModuleDto> findAll() {
        List<SysModuleDto> permissions = new ArrayList<SysModuleDto>();
        List<SysModule> sysModules = moduleManager.selectByExample(new SysModuleExample());
        for (SysModule sysModule : sysModules) {
            permissions.add(SysModuleDto.domain2dto(sysModule));
        }
        return permissions;
    }

    @Override
    public List<SysModuleDto> findAllByStatus(Integer status) {
        return moduleManager.selectAllByState(status);
    }

    @Override
    public List<Map> findModuleTree() {
        return TreeUtil.createTreeByList(findAllByStatus(1));
    }

    @Override
    public List<SysModuleDto> findListByPid(String pid) {
        return moduleManager.selectListByPid(pid);
    }

    @Override
    public SysModuleDto getById(Long id) {
        SysModule sysModule = moduleManager.selectByPrimaryKey(id);
        return SysModuleDto.domain2dto(sysModule);
    }

    @Override
    public Long save(SysModuleDto moduleDto) {
        SysModule sysModule = SysModuleDto.dto2domain(moduleDto);
        moduleManager.insertSelective(sysModule);
        initProcessor.initMenuSet();
        return sysModule.getId();
    }

    @Override
    public void update(SysModuleDto moduleDto) {
        moduleManager.updateByPrimaryKeySelective(SysModuleDto.dto2domain(moduleDto));
        initProcessor.initMenuSet();
    }

    @Override
    public void deleteById(Long id) {
        moduleManager.deleteByPrimaryKey(id);
    }


    @Override
    public List<SysModuleDto> findListByRoleId(Long roleId) {
        return moduleManager.findListByRoleId(roleId);
    }

    @Override
    public List<Map> findModuleTreeByRoleId(Long roleId) {
        List<SysModuleDto> list = moduleManager.findListByRoleId(roleId);
        return TreeUtil.createTreeByList(list);
    }

    @Override
    public List<Map> findOrgModuleTreeByOrgId(Long orgId) {
        List<Map> list = new ArrayList<>();
        SysOrgDto sysOrg = orgService.getById(orgId);
        List<SysRoleDto> roles = roleService.findListByOrgId(sysOrg.getLv().longValue());
        if (roles != null && roles.size() > 0) {
            list = findModuleTreeByRoleId(roles.get(0).getId());
        }
        return list;
    }


}
