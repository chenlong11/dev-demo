package cn.ksource.mapper.demo;

import cn.ksource.domain.demo.DemoExample;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by chenlong
 * Date：2018/9/14
 * time：17:28
 */
public class DemoDaoProvider {

    public String selectByExample(DemoExample example) {
        SQL sql = new SQL();
        sql.SELECT("id,a_string,a_integer,a_double,a_long,create_date");
        sql.FROM("demo");
        if (example.getAString() != null) {
            sql.WHERE(" a_string like '%' || #{aString,jdbcType=VARCHAR} || '%'");
        }
        if (example.getAInteger() != null) {
            sql.WHERE("a_integer = #{aInteger,jdbcType=INTEGER}");
        }

        if (example.getADouble() != null) {
            sql.WHERE("a_double = #{aDouble,jdbcType=DECIMAL}");
        }

        if (example.getALong() != null) {
            sql.WHERE("a_long = #{aLong,jdbcType=BIGINT}");
        }
        sql.ORDER_BY("create_date desc");
        return sql.toString();
    }

}
