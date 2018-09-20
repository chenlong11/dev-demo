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
        
        if (record.getDemoString() != null) {
            sql.VALUES("demo_string", "#{demoString,jdbcType=VARCHAR}");
        }
        
        if (record.getDemoInt() != null) {
            sql.VALUES("demo_int", "#{demoInt,jdbcType=INTEGER}");
        }
        
        if (record.getDemoDouble() != null) {
            sql.VALUES("demo_double", "#{demoDouble,jdbcType=DECIMAL}");
        }
        
        if (record.getDemoLong() != null) {
            sql.VALUES("demo_long", "#{demoLong,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("state", "#{state,jdbcType=SMALLINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Demo record) {
        SQL sql = new SQL();
        sql.UPDATE("demo");
        
        if (record.getDemoString() != null) {
            sql.SET("demo_string = #{demoString,jdbcType=VARCHAR}");
        }
        
        if (record.getDemoInt() != null) {
            sql.SET("demo_int = #{demoInt,jdbcType=INTEGER}");
        }
        
        if (record.getDemoDouble() != null) {
            sql.SET("demo_double = #{demoDouble,jdbcType=DECIMAL}");
        }
        
        if (record.getDemoLong() != null) {
            sql.SET("demo_long = #{demoLong,jdbcType=BIGINT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            sql.SET("state = #{state,jdbcType=SMALLINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}