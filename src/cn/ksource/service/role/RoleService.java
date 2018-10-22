package cn.ksource.service.role;

import cn.ksource.domain.role.SysRoleDto;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:13
 */
public interface RoleService {
    
    List<SysRoleDto> findByUserId(Long id);

    List<SysRoleDto> findListByOrgId(Long orgId);

    SysRoleDto getById(Long id);

    void save(SysRoleDto roleDto);

    void update(SysRoleDto roleDto);

    void deleteById(Long id);

    void saveModule(Long[] moduleIds, Long roleId);

    void delRoleModuleById(Long id);

    void saveUser(Long[] userIds, Long roleId);

    List<SysRoleDto> findReserveList();

    boolean isSuperAdmin(Long userId);
}
