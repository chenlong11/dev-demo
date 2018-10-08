package cn.ksource.service.LocalAuth;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.ksource.constants.Constants;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.domain.sysModule.SysModuleDto;
import cn.ksource.domain.sysRole.SysRoleDto;
import cn.ksource.domain.sysUser.SysUserDto;
import cn.ksource.exception.AccountAuthErrException;
import cn.ksource.exception.AuthCodeErrException;
import cn.ksource.mapper.sysLocalAuth.SysLocalAuthManager;
import cn.ksource.service.SysModuleService;
import cn.ksource.service.role.SysRoleService;
import cn.ksource.service.sysUser.SysUserService;
import cn.ksource.util.ContextUtil;
import cn.ksource.util.CryptUtil;
import cn.ksource.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:34
 */
@Service
public class SysLocalAuthServiceImpl implements SysLocalAuthService {

    @Autowired
    private SysLocalAuthManager localAuthDao;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysModuleService sysModuleService;

    @Autowired
    private SysRoleService SysRoleService;

    @Override
    public String authAccount(String account, String password) {
        return localAuthDao.authAccount(account, password);
    }

    @Override
    public ResponseResult localauth(String account, String password, String code) {

        if (StrUtil.isBlank(code)) {
            throw new AuthCodeErrException("验证码不能为空");
        }

        String authCode = Convert.toStr(ContextUtil.getSessionAttr(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY));
        if(!authCode.equals(code)){
            throw new AuthCodeErrException("验证码错误");
        }

        String userId = localAuthDao.authAccount(account, CryptUtil.getEncryptPassword(account, password));
        if (StrUtil.isBlank(userId)) {
            throw new AccountAuthErrException("账号或密码错误");
        }

        //用户基本信息
        SysUserDto sysUserDto = sysUserService.selectById(userId);
        //角色
        List<SysRoleDto> roles = SysRoleService.findByUserId(userId);
        if (roles != null) {
            sysUserDto.setRoles(roles);
        }
        //权限
        List<SysModuleDto> modules = sysModuleService.findListByUserId(userId);
        if (modules != null) {
            sysUserDto.setModules(TreeUtil.createTreeByList(modules));
        }

        ContextUtil.setSessionAttr(Constants.USER_LOGIN_IDENTIFY,sysUserDto);

        return new ResponseResult();
    }

}
