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
        "insert into demo (id, demo_string, ",
        "demo_int, demo_double, ",
        "demo_long, create_date, ",
        "create_time, state)",
        "values (#{id,jdbcType=VARCHAR}, #{demoString,jdbcType=VARCHAR}, ",
        "#{demoInt,jdbcType=INTEGER}, #{demoDouble,jdbcType=DECIMAL}, ",
        "#{demoLong,jdbcType=BIGINT}, #{createDate,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=INTEGER}, #{state,jdbcType=SMALLINT})"
    })
    int insert(Demo record);

    @InsertProvider(type=DemoSqlProvider.class, method="insertSelective")
    int insertSelective(Demo record);

    @Select({
        "select",
        "id, demo_string, demo_int, demo_double, demo_long, create_date, create_time, ",
        "state",
        "from demo",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="demo_string", property="demoString", jdbcType=JdbcType.VARCHAR),
        @Result(column="demo_int", property="demoInt", jdbcType=JdbcType.INTEGER),
        @Result(column="demo_double", property="demoDouble", jdbcType=JdbcType.DECIMAL),
        @Result(column="demo_long", property="demoLong", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.SMALLINT)
    })
    Demo selectByPrimaryKey(String id);

    @UpdateProvider(type=DemoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Demo record);

    @Update({
        "update demo",
        "set demo_string = #{demoString,jdbcType=VARCHAR},",
          "demo_int = #{demoInt,jdbcType=INTEGER},",
          "demo_double = #{demoDouble,jdbcType=DECIMAL},",
          "demo_long = #{demoLong,jdbcType=BIGINT},",
          "create_date = #{createDate,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=INTEGER},",
          "state = #{state,jdbcType=SMALLINT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Demo record);
}