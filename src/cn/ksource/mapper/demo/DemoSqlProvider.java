package cn.ksource.mapper.demo;

import cn.ksource.domain.demo.Demo;
import org.apache.ibatis.jdbc.SQL;

public class DemoSqlProvider {

    public String insertSelective(Demo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("demo");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getaString() != null) {
            sql.VALUES("a_string", "#{aString,jdbcType=VARCHAR}");
        }
        
        if (record.getaInteger() != null) {
            sql.VALUES("a_integer", "#{aInteger,jdbcType=INTEGER}");
        }
        
        if (record.getaDouble() != null) {
            sql.VALUES("a_double", "#{aDouble,jdbcType=DECIMAL}");
        }
        
        if (record.getaLong() != null) {
            sql.VALUES("a_long", "#{aLong,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=INTEGER}");
        }
        
        if (record.getStatu() != null) {
            sql.VALUES("statu", "#{statu,jdbcType=SMALLINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Demo record) {
        SQL sql = new SQL();
        sql.UPDATE("demo");
        
        if (record.getaString() != null) {
            sql.SET("a_string = #{aString,jdbcType=VARCHAR}");
        }
        
        if (record.getaInteger() != null) {
            sql.SET("a_integer = #{aInteger,jdbcType=INTEGER}");
        }
        
        if (record.getaDouble() != null) {
            sql.SET("a_double = #{aDouble,jdbcType=DECIMAL}");
        }
        
        if (record.getaLong() != null) {
            sql.SET("a_long = #{aLong,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=INTEGER}");
        }
        
        if (record.getStatu() != null) {
            sql.SET("statu = #{statu,jdbcType=SMALLINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}