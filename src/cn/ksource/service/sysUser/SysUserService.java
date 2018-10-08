package cn.ksource.service.sysUser;

import cn.ksource.domain.sysUser.SysUser;
import cn.ksource.domain.sysUser.SysUserDto;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:37
 */
public interface SysUserService {

    public SysUserDto selectById(String id);

}
