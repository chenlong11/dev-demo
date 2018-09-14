package cn.ksource.domain.xss;


import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2017/12/12
 * time：10:08
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {

    public XssRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        return clearXss(super.getHeader(name));
    }

    @Override
    public String getQueryString() {
        return clearXss(super.getQueryString());
    }

    @Override
    public String getParameter(String name) {
        return clearXss(super.getParameter(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if(values != null) {
            int length = values.length;
            String[] escapseValues = new String[length];
            for(int i = 0; i < length; i++){
                escapseValues[i] = clearXss(values[i]);
            }
            return escapseValues;
        }
        return super.getParameterValues(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameterMap = super.getParameterMap();
        if (parameterMap != null) {
            for (String k : parameterMap.keySet()) {
                String[] values = parameterMap.get(k);
                if(values != null) {
                    int length = values.length;
                    for(int i = 0; i < length; i++){
                        values[i] = clearXss(values[i]);
                    }
                }
            }
        }
        return super.getParameterMap();
    }

    private String clearXss(String value) {
        if(StrUtil.isNotBlank(value)){
            if((value.startsWith("[")&&value.endsWith("]"))||(value.startsWith("{")&&value.endsWith("}"))){
                return value;
            } else {
                value = value.replace("\\", "")
                        .replace("%", "")
                        .replace("(", "")
                        .replace(")", "")
                        .replace(";","");
            }
        }
        return StringEscapeUtils.escapeHtml4(value);
    }


}
