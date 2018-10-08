package cn.ksource.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by chenlong
 * Date：2018/9/14
 * time：14:19
 */
public class DateSupportUtil {

    public static Integer getCurDate(){
        return Integer.valueOf(getDateByExpression("yyyyMMdd"));
    }

    public static Integer getCurTime(){
        return Integer.valueOf(getDateByExpression("HHmmss"));
    }

    public static String getDateByExpression(String expression) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(expression);
        return df.format(c.getTime());
    }

}
