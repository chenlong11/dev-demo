package cn.ksource.service.LocalAuth;

import cn.ksource.domain.response.ResponseResult;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:33
 */
public interface LocalAuthService {

    /**
     * 账号是否存在
     * @param account
     * @param password
     * @return
     */
    Long authAccount(String account, String password);

    /**
     * 本地登陆认证
     * @param account
     * @param password
     * @param code
     */
    ResponseResult localauth(String account, String password, String code);

}
