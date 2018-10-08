package cn.ksource.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropConstants {

    public static String appName;

    public static String appVersion;

    @Value("${app.name}")
    public void setAppName(String appName) {
        PropConstants.appName = appName;
    }
    @Value("${app.version}")
    public void setAppVersion(String appVersion) {
        PropConstants.appVersion = appVersion;
    }
}
