package cn.ksource.mapper.dept;

import cn.ksource.domain.dept.SysDept;
import cn.ksource.domain.dept.SysDeptExample;
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

public interface SysDeptMapper {
    @SelectProvider(type=SysDeptSqlProvider.class, method="countByExample")
    long countByExample(SysDeptExample example);

    @DeleteProvider(type=SysDeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDeptExample example);

    @Delete({
        "delete from sys_dept",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_dept (id, org_id, ",
        "dept_name, dept_code, ",
        "lv, pid, sn, ",
        "create_date, create_time, ",
        "state)",
        "values (#{id,jdbcType=BIGINT}, #{orgId,jdbcType=BIGINT}, ",
        "#{deptName,jdbcType=VARCHAR}, #{deptCode,jdbcType=VARCHAR}, ",
        "#{lv,jdbcType=TINYINT}, #{pid,jdbcType=BIGINT}, #{sn,jdbcType=SMALLINT}, ",
        "#{createDate,jdbcType=DATE}, #{createTime,jdbcType=TIME}, ",
        "#{state,jdbcType=TINYINT})"
    })
    int insert(SysDept record);

    @InsertProvider(type=SysDeptSqlProvider.class, method="insertSelective")
    int insertSelective(SysDept record);

    @SelectProvider(type=SysDeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="org_id", property="orgId", jdbcType=JdbcType.BIGINT),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_code", property="deptCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="lv", property="lv", jdbcType=JdbcType.TINYINT),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    List<SysDept> selectByExample(SysDeptExample example);

    @Select({
        "select",
        "id, org_id, dept_name, dept_code, lv, pid, sn, create_date, create_time, state",
        "from sys_dept",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="org_id", property="orgId", jdbcType=JdbcType.BIGINT),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_code", property="deptCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="lv", property="lv", jdbcType=JdbcType.TINYINT),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    SysDept selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDept record);

    @Update({
        "update sys_dept",
        "set org_id = #{orgId,jdbcType=BIGINT},",
          "dept_name = #{deptName,jdbcType=VARCHAR},",
          "dept_code = #{deptCode,jdbcType=VARCHAR},",
          "lv = #{lv,jdbcType=TINYINT},",
          "pid = #{pid,jdbcType=BIGINT},",
          "sn = #{sn,jdbcType=SMALLINT},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIME},",
          "state = #{state,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysDept record);
}