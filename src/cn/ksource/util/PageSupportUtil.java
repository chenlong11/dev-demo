package cn.ksource.util;

import com.github.pagehelper.Page;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.util.List;

public class PageSupportUtil {

    public static <T> Page<T> list2Page(List<?> list, Class<T> t) {

        if (list == null || list.isEmpty()) {
            return new Page<T>();
        }
        Page page = new Page();
        BeanUtils.copyProperties((Page) list, page);
        page.clear();
        Class<?> clazz = list.get(0).getClass();
        for (Object e :list){
            Method method;
            try {
                method = t.getMethod("domain2dto", clazz);
                page.add(method.invoke(t, e));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return page;
    }

}
