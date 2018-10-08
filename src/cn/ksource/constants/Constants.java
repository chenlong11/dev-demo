package cn.ksource.constants;

import cn.hutool.setting.dialect.Props;

/**
 * Created by chenlong
 * Date：2018/9/12
 * time：12:04
 */
public class Constants {

    public static String HOST_LIST;

    static {
        Props props = new Props("app.properties");
        HOST_LIST = props.getStr("app.hosts");
    }

    //PC用户登陆标识
    public static final String USER_LOGIN_IDENTIFY = "user_login_identify";

    //AES加密参数
    public static final String AES_KEY = "6543210987654321";
    public static final String AES_IV = "1234567890123456";

    //异步请求超时
    public static final String AJAX_LOGIN_TIME_OUT = "ajax_login_time_out";


}
