package cn.ksource.mapper.dic;

import cn.ksource.domain.dic.SysDic;
import cn.ksource.domain.dic.SysDicExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysDicMapper {
    @SelectProvider(type=SysDicSqlProvider.class, method="countByExample")
    long countByExample(SysDicExample example);

    @DeleteProvider(type=SysDicSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDicExample example);

    @Delete({
            "delete from sys_dic",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_dic (id, dic_name, ",
        "dic_code, sn, create_date, ",
        "create_time, state)",
        "values (#{id,jdbcType=BIGINT}, #{dicName,jdbcType=VARCHAR}, ",
        "#{dicCode,jdbcType=VARCHAR}, #{sn,jdbcType=SMALLINT}, #{createDate,jdbcType=DATE}, ",
        "#{createTime,jdbcType=TIME}, #{state,jdbcType=TINYINT})"
    })
    int insert(SysDic record);

    @InsertProvider(type=SysDicSqlProvider.class, method="insertSelective")
    int insertSelective(SysDic record);

    @SelectProvider(type=SysDicSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dic_name", property="dicName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dic_code", property="dicCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    List<SysDic> selectByExample(SysDicExample example);

    @Select({
        "select",
        "id, dic_name, dic_code, sn, create_date, create_time, state",
        "from sys_dic",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dic_name", property="dicName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dic_code", property="dicCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    SysDic selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysDicSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDic record, @Param("example") SysDicExample example);

    @UpdateProvider(type=SysDicSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDic record, @Param("example") SysDicExample example);

    @UpdateProvider(type=SysDicSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDic record);

    @Update({
        "update sys_dic",
        "set dic_name = #{dicName,jdbcType=VARCHAR},",
          "dic_code = #{dicCode,jdbcType=VARCHAR},",
          "sn = #{sn,jdbcType=SMALLINT},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIME},",
          "state = #{state,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysDic record);
}