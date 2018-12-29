package cn.ksource.service.role;

import cn.ksource.domain.moduleRole.SysModuleRole;
import cn.ksource.domain.moduleRole.SysModuleRoleExample;
import cn.ksource.domain.role.SysRole;
import cn.ksource.domain.role.SysRoleDto;
import cn.ksource.domain.role.SysRoleExample;
import cn.ksource.domain.userRole.SysUserRole;
import cn.ksource.domain.userRole.SysUserRoleExample;
import cn.ksource.mapper.moduleRole.SysModuleRoleManager;
import cn.ksource.mapper.role.SysRoleManager;
import cn.ksource.mapper.userRole.SysUserRoleManager;
import cn.ksource.util.UidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:17
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleManager roleManager;

    @Autowired
    private SysModuleRoleManager moduleRoleManager;

    @Autowired
    private SysUserRoleManager userRoleManager;



    @Override
    public List<SysRoleDto> findByUserId(Long id) {
        if (roleManager.findByUserId(id) == null) {
            return new ArrayList<SysRoleDto>();
        }
        return roleManager.findByUserId(id);
    }

    @Override
    public List<SysRoleDto> findListByOrgId(Long orgId) {
        return roleManager.getListByOrgId(orgId);
    }

    @Override
    public SysRoleDto getById(Long id) {
        return SysRoleDto.domain2dto(roleManager.selectByPrimaryKey(id));
    }

    @Override
    public void save(SysRoleDto roleDto) {
        roleManager.insertSelective(SysRoleDto.dto2domain(roleDto));
    }

    @Override
    public void update(SysRoleDto roleDto) {
        roleManager.updateByPrimaryKeySelective(SysRoleDto.dto2domain(roleDto));
    }

    @Override
    public void deleteById(Long id) {
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setState(Byte.valueOf("0"));
        roleManager.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public void saveModule(Long[] moduleIds, Long roleId) {

        delRoleModuleById(roleId);

        if (moduleIds == null || moduleIds.length == 0) {
            return;
        }

        for (Long moduleId : moduleIds) {
            SysModuleRole sysModuleRole = new SysModuleRole();
            sysModuleRole.setId(UidUtils.getUID());
            sysModuleRole.setRoleId(roleId);
            sysModuleRole.setModuleId(moduleId);
            moduleRoleManager.insertSelective(sysModuleRole);
        }
    }

    @Override
    public void delRoleModuleById(Long id) {
        SysModuleRoleExample example = new SysModuleRoleExample();
        SysModuleRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(id);
        moduleRoleManager.deleteByExample(example);
    }

    @Override
    public void saveUser(Long[] userIds, Long roleId) {

        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        userRoleManager.deleteByExample(example);

        if (userIds != null && userIds.length > 0){
            for (Long userId : userIds) {
                if(userId.equals(-1L)){
                    continue;
                }
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setId(UidUtils.getUID());
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                userRoleManager.insertSelective(sysUserRole);
            }
        }
    }

    @Override
    public List<SysRoleDto> findReserveList() {
        ArrayList<SysRoleDto> sysRoleDtos = new ArrayList<>();

        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andOrgIdBetween(1L, 3L);
        List<SysRole> sysRoles = roleManager.selectByExample(example);
        for (SysRole sysRole : sysRoles) {
            sysRoleDtos.add(SysRoleDto.domain2dto(sysRole));
        }
        return sysRoleDtos;
    }

    @Override
    public boolean isSuperAdmin(Long userId) {
        long count = roleManager.selectSuperCountByUserId(userId);
        if (count > 0) {
            return true;
        }
        return false;
    }

}
