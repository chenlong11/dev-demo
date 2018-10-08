package cn.ksource.filter;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.ksource.constants.Constants;
import cn.ksource.domain.sysUser.SysUserDto;
import cn.ksource.initialize.InitProcessor;
import cn.ksource.util.ContextUtil;
import cn.ksource.util.HttpSupportUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@WebFilter(filterName = "Filter2_Admin",value = "/admin/*")
public class AdminLoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri =HttpSupportUtil.getURI(request);

        String[] anon = {"/admin/login","/admin/loginFailure","/admin/logout","/admin/nopermission"};
        //未登陆，返回登陆页
        SysUserDto sysUserDto = ContextUtil.getLoginUser();
        if (!Arrays.asList(anon).contains(uri) && sysUserDto == null) {
            String requestType = request.getHeader("X-Requested-With");
            if(StrUtil.isNotBlank(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")){
                HttpSupportUtil.write(response, Constants.AJAX_LOGIN_TIME_OUT);
                return;
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/loginFailure.html");
            dispatcher.forward(request, response);
            return;
        }

        //链接属于功能菜单,进行权限过滤
        if (InitProcessor.allModule.get(uri) != null) {
            boolean nopermisson = true;
            String lv3moduleCode = InitProcessor.allModule.get(uri);
            List<Map> modules = sysUserDto.getModules();
            String lv1moduleCode = lv3moduleCode.substring(0,lv3moduleCode.indexOf(":"));
            String lv2moduleCode = lv3moduleCode.substring(0,lv3moduleCode.lastIndexOf(":"));
            for (Map lv1module : modules) {
                if (Convert.toStr(lv1module.get("moduleCode")).equals(lv1moduleCode)) {
                    nopermisson = false;
                    request.setAttribute("lv1module", lv1module);
                    request.setAttribute("lv2moduleCode", lv2moduleCode);
                    request.setAttribute("lv3moduleCode", lv3moduleCode);
                    break;
                }
            }
            if(nopermisson){//没有权限
                log.warn(" nopermission ！ , request uri is : {} ", uri);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/nopermission.html");
                dispatcher.forward(request, response);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
