package cn.ksource.util;

import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HttpSupportUtil {

    public static void write(HttpServletResponse response, String str) {
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(str);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 移除字符串中重复的斜杠
     * @param str
     * @return
     */
    public static String removeRepeatSlash(String str) {
        String regex = "/+";
        String result=str.replaceAll(regex,"/");
        return result;
    }

    public static String getURI(HttpServletRequest request) {
        return removeRepeatSlash(request.getRequestURI().replaceFirst(request.getContextPath(), ""));
    }

    public static String getURL(HttpServletRequest request) {
        String url = new String(getURI(request));
        if (StrUtil.isNotBlank(request.getQueryString())) {
            url = url + "?" + request.getQueryString();
        }
        return url;
    }

}
