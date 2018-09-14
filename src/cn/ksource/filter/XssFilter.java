package cn.ksource.filter;

import cn.hutool.core.util.StrUtil;
import cn.ksource.constants.Constants;
import cn.ksource.domain.xss.XssRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by chenlong
 * Date：2018/9/12
 * time：11:25
 */
@Slf4j
@WebFilter(filterName = "Filter1_Xss",value = "/*")
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (!checkHeader(request)) {
            return;
        }
        filterChain.doFilter(new XssRequestWrapper(request), servletResponse);
    }

    private boolean checkHeader(HttpServletRequest request) {
        String curhost = request.getHeader("host");
        if (StrUtil.isBlank(curhost)) {
            log.info("hosts为空");
            return false;
        }

        curhost = curhost.substring(0,curhost.indexOf(":"));

        if (Constants.HOST_LIST.indexOf(curhost) < 0) {
            log.info("请求host不在白名单内 。curhost：{}，hostsWhiteList：{}", curhost, Constants.HOST_LIST);
            return false;
        }
        return true;
    }

    @Override
    public void destroy() {
    }

}
