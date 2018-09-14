package cn.ksource.mapper.demo;

import cn.ksource.domain.demo.Demo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DemoMapper {
    @Delete({
        "delete from demo",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into demo (id, a_string, ",
        "a_integer, a_double, ",
        "a_long, create_date, ",
        "create_time, statu)",
        "values (#{id,jdbcType=VARCHAR}, #{aString,jdbcType=VARCHAR}, ",
        "#{aInteger,jdbcType=INTEGER}, #{aDouble,jdbcType=DECIMAL}, ",
        "#{aLong,jdbcType=BIGINT}, #{createDate,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=INTEGER}, #{statu,jdbcType=SMALLINT})"
    })
    int insert(Demo record);

    @InsertProvider(type=DemoSqlProvider.class, method="insertSelective")
    int insertSelective(Demo record);

    @Select({
        "select",
        "id, a_string, a_integer, a_double, a_long, create_date, create_time, statu",
        "from demo",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="a_string", property="aString", jdbcType=JdbcType.VARCHAR),
        @Result(column="a_integer", property="aInteger", jdbcType=JdbcType.INTEGER),
        @Result(column="a_double", property="aDouble", jdbcType=JdbcType.DECIMAL),
        @Result(column="a_long", property="aLong", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.INTEGER),
        @Result(column="statu", property="statu", jdbcType=JdbcType.SMALLINT)
    })
    Demo selectByPrimaryKey(String id);

    @UpdateProvider(type=DemoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Demo record);

    @Update({
        "update demo",
        "set a_string = #{aString,jdbcType=VARCHAR},",
          "a_integer = #{aInteger,jdbcType=INTEGER},",
          "a_double = #{aDouble,jdbcType=DECIMAL},",
          "a_long = #{aLong,jdbcType=BIGINT},",
          "create_date = #{createDate,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=INTEGER},",
          "statu = #{statu,jdbcType=SMALLINT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Demo record);
}