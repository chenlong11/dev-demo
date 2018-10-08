package cn.ksource.service.sysUser;

import cn.ksource.domain.sysUser.SysUser;
import cn.ksource.domain.sysUser.SysUserDto;
import cn.ksource.mapper.sysUser.SysUserManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:37
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserManager sysUserDao;


    @Override
    public SysUserDto selectById(String id) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(id);
        SysUserDto sysUserDto = new SysUserDto();
        BeanUtils.copyProperties(sysUser, sysUserDto);
        return sysUserDto;
    }

}
