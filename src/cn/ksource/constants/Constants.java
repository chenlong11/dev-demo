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

}
