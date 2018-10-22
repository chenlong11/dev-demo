package cn.ksource.service.user;

import cn.ksource.domain.dept.SysDeptDto;
import cn.ksource.domain.user.SysUserDto;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:37
 */
public interface UserService {

    SysUserDto getById(Long id);

    List<SysUserDto> findListByOrgId(Long orgId);

    void save(SysUserDto userDto);

    void update(SysUserDto userDto);

    void deleteById(Long id);

    List<SysDeptDto> findDeptAndUserByOrgId(Long orgId);

    List<SysUserDto> findListByRoleId(Long roleId);

    boolean isAccountExist(String accountName, Long id);

    List<SysUserDto> findListByOrgAndDeptId(Long orgId, Long deptId);
}
