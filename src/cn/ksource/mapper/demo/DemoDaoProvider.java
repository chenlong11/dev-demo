package cn.ksource.mapper.demo;

import cn.ksource.domain.demo.DemoExample;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by chenlong
 * Date：2018/9/14
 * time：17:28
 */
public class DemoDaoProvider {

    public String DemoDaoProvider(DemoExample example) {
        SQL sql = new SQL();
        sql.SET("id,a_string,a_integer,a_double,a_long,create_date");
        sql.FROM("demo");
        if (example.getAString() != null) {
            sql.WHERE(" a_string = #{aString,jdbcType=VARCHAR} ");
        }
        if (example.getAInteger() != null) {
            sql.SET("a_integer = #{aInteger,jdbcType=INTEGER}");
        }

        if (example.getADouble() != null) {
            sql.SET("a_double = #{aDouble,jdbcType=DECIMAL}");
        }

        if (example.getALong() != null) {
            sql.SET("a_long = #{aLong,jdbcType=BIGINT}");
        }
        return sql.toString();
    }

}
