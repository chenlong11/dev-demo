package cn.ksource.service.role;

import cn.ksource.domain.sysRole.SysRoleDto;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:13
 */
public interface SysRoleService {
    List<SysRoleDto> findByUserId(String id);
}
