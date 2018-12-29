package cn.ksource.service.LocalAuth;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.ksource.constants.Constants;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.domain.module.SysModuleDto;
import cn.ksource.domain.role.SysRoleDto;
import cn.ksource.domain.user.SysUserDto;
import cn.ksource.exception.AccountAuthErrException;
import cn.ksource.exception.AuthCodeErrException;
import cn.ksource.mapper.localAuth.SysLocalAuthManager;
import cn.ksource.service.module.ModuleService;
import cn.ksource.service.role.RoleService;
import cn.ksource.service.user.UserService;
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
public class LocalAuthServiceImpl implements LocalAuthService {

    @Autowired
    private SysLocalAuthManager localAuthManager;

    @Autowired
    private UserService sysUserService;

    @Autowired
    private ModuleService sysModuleService;

    @Autowired
    private RoleService SysRoleService;

    @Override
    public Long authAccount(String account, String password) {
        return localAuthManager.authAccount(account, password);
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

        Long userId = localAuthManager.authAccount(account, CryptUtil.getEncryptPassword(account, password));
        if (userId == null) {
            throw new AccountAuthErrException("账号或密码错误");
        }

        //用户基本信息
        SysUserDto sysUserDto = sysUserService.getById(userId);
        //角色
        List<SysRoleDto> roles = SysRoleService.findByUserId(userId);
        if (roles != null) {
            sysUserDto.setRoles(roles);
        }
        //权限
        List<SysModuleDto> modules = sysModuleService.findListByUserId(userId);
        for (SysModuleDto module : modules) {
            sysUserDto.getModuleCodes().add(module.getModuleCode());
        }

        if (modules != null) {
            sysUserDto.setModules(TreeUtil.createTreeByList(modules));
        }
        ContextUtil.setSessionAttr(Constants.USER_LOGIN_IDENTIFY,sysUserDto);
        return new ResponseResult();
    }

}
