package cn.ksource.util;

import cn.ksource.constants.Constants;
import cn.ksource.domain.sysUser.SysUserDto;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:57
 */
public class ContextUtil {

    public static HttpServletRequest getRequest() {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return req;
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse resp = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
        return resp;
    }

    public static void invalidateSesession() {
        getRequest().getSession().invalidate();
    }

    public static void setSessionAttr(String key, Object obj) {
        getRequest().getSession().setAttribute(key, obj);
    }

    public static Object getSessionAttr(String key) {
        return getRequest().getSession().getAttribute(key);
    }

    public static void removeSessionAttr(String key) {
        getRequest().getSession().removeAttribute(key);
    }

    public static SysUserDto getLoginUser() {
        return (SysUserDto) getSessionAttr(Constants.USER_LOGIN_IDENTIFY);
    }

    public static void clearAdminSession() {
        removeSessionAttr(Constants.USER_LOGIN_IDENTIFY);
        invalidateSesession();
    }

}
