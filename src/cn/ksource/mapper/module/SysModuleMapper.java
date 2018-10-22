package cn.ksource.mapper.module;

import cn.ksource.domain.module.SysModule;
import cn.ksource.domain.module.SysModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysModuleMapper {
    @SelectProvider(type=SysModuleSqlProvider.class, method="countByExample")
    long countByExample(SysModuleExample example);

    @DeleteProvider(type=SysModuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysModuleExample example);

    @Delete({
        "delete from sys_module",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_module (id, module_type, ",
        "module_code, module_name, ",
        "module_url, pid, lv, ",
        "sn, create_date, create_time, ",
        "state)",
        "values (#{id,jdbcType=BIGINT}, #{moduleType,jdbcType=TINYINT}, ",
        "#{moduleCode,jdbcType=VARCHAR}, #{moduleName,jdbcType=VARCHAR}, ",
        "#{moduleUrl,jdbcType=VARCHAR}, #{pid,jdbcType=BIGINT}, #{lv,jdbcType=TINYINT}, ",
        "#{sn,jdbcType=SMALLINT}, #{createDate,jdbcType=DATE}, #{createTime,jdbcType=TIME}, ",
        "#{state,jdbcType=TINYINT})"
    })
    int insert(SysModule record);

    @InsertProvider(type=SysModuleSqlProvider.class, method="insertSelective")
    int insertSelective(SysModule record);

    @SelectProvider(type=SysModuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.TINYINT),
        @Result(column="module_code", property="moduleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_name", property="moduleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_url", property="moduleUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="lv", property="lv", jdbcType=JdbcType.TINYINT),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    List<SysModule> selectByExample(SysModuleExample example);

    @Select({
        "select",
        "id, module_type, module_code, module_name, module_url, pid, lv, sn, create_date, ",
        "create_time, state",
        "from sys_module",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.TINYINT),
        @Result(column="module_code", property="moduleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_name", property="moduleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_url", property="moduleUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="lv", property="lv", jdbcType=JdbcType.TINYINT),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    SysModule selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysModuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysModule record, @Param("example") SysModuleExample example);

    @UpdateProvider(type=SysModuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysModule record, @Param("example") SysModuleExample example);

    @UpdateProvider(type=SysModuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysModule record);

    @Update({
        "update sys_module",
        "set module_type = #{moduleType,jdbcType=TINYINT},",
          "module_code = #{moduleCode,jdbcType=VARCHAR},",
          "module_name = #{moduleName,jdbcType=VARCHAR},",
          "module_url = #{moduleUrl,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=BIGINT},",
          "lv = #{lv,jdbcType=TINYINT},",
          "sn = #{sn,jdbcType=SMALLINT},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIME},",
          "state = #{state,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysModule record);
}