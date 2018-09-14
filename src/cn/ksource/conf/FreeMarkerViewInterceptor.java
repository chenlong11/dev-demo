package cn.ksource.conf;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenlong
 * Date：2018/9/12
 * time：16:21
 */
public class FreeMarkerViewInterceptor  extends HandlerInterceptorAdapter {

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView view) throws Exception {
        String contextPath = request.getContextPath();
        if (view != null) {
            request.setAttribute("ctx", contextPath);
        }
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }


}
