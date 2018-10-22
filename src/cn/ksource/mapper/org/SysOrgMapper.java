package cn.ksource.mapper.org;

import cn.ksource.domain.org.SysOrg;
import cn.ksource.domain.org.SysOrgExample;
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

public interface SysOrgMapper {
    @SelectProvider(type=SysOrgSqlProvider.class, method="countByExample")
    long countByExample(SysOrgExample example);

    @DeleteProvider(type=SysOrgSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysOrgExample example);

    @Delete({
        "delete from sys_org",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_org (id, lv1_id, ",
        "lv1_name, lv2_id, lv2_name, ",
        "lv3_id, lv3_name, org_name, ",
        "org_code, lv, pid, ",
        "org_path, sn, create_date, ",
        "create_time, state)",
        "values (#{id,jdbcType=BIGINT}, #{lv1Id,jdbcType=BIGINT}, ",
        "#{lv1Name,jdbcType=VARCHAR}, #{lv2Id,jdbcType=BIGINT}, #{lv2Name,jdbcType=VARCHAR}, ",
        "#{lv3Id,jdbcType=BIGINT}, #{lv3Name,jdbcType=VARCHAR}, #{orgName,jdbcType=VARCHAR}, ",
        "#{orgCode,jdbcType=VARCHAR}, #{lv,jdbcType=TINYINT}, #{pid,jdbcType=BIGINT}, ",
        "#{orgPath,jdbcType=VARCHAR}, #{sn,jdbcType=SMALLINT}, #{createDate,jdbcType=DATE}, ",
        "#{createTime,jdbcType=TIME}, #{state,jdbcType=TINYINT})"
    })
    int insert(SysOrg record);

    @InsertProvider(type=SysOrgSqlProvider.class, method="insertSelective")
    int insertSelective(SysOrg record);

    @SelectProvider(type=SysOrgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="lv1_id", property="lv1Id", jdbcType=JdbcType.BIGINT),
        @Result(column="lv1_name", property="lv1Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="lv2_id", property="lv2Id", jdbcType=JdbcType.BIGINT),
        @Result(column="lv2_name", property="lv2Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="lv3_id", property="lv3Id", jdbcType=JdbcType.BIGINT),
        @Result(column="lv3_name", property="lv3Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_name", property="orgName", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_code", property="orgCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="lv", property="lv", jdbcType=JdbcType.TINYINT),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="org_path", property="orgPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    List<SysOrg> selectByExample(SysOrgExample example);

    @Select({
        "select",
        "id, lv1_id, lv1_name, lv2_id, lv2_name, lv3_id, lv3_name, org_name, org_code, ",
        "lv, pid, org_path, sn, create_date, create_time, state",
        "from sys_org",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="lv1_id", property="lv1Id", jdbcType=JdbcType.BIGINT),
        @Result(column="lv1_name", property="lv1Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="lv2_id", property="lv2Id", jdbcType=JdbcType.BIGINT),
        @Result(column="lv2_name", property="lv2Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="lv3_id", property="lv3Id", jdbcType=JdbcType.BIGINT),
        @Result(column="lv3_name", property="lv3Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_name", property="orgName", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_code", property="orgCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="lv", property="lv", jdbcType=JdbcType.TINYINT),
        @Result(column="pid", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="org_path", property="orgPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    SysOrg selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysOrgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    @UpdateProvider(type=SysOrgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    @UpdateProvider(type=SysOrgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysOrg record);

    @Update({
        "update sys_org",
        "set lv1_id = #{lv1Id,jdbcType=BIGINT},",
          "lv1_name = #{lv1Name,jdbcType=VARCHAR},",
          "lv2_id = #{lv2Id,jdbcType=BIGINT},",
          "lv2_name = #{lv2Name,jdbcType=VARCHAR},",
          "lv3_id = #{lv3Id,jdbcType=BIGINT},",
          "lv3_name = #{lv3Name,jdbcType=VARCHAR},",
          "org_name = #{orgName,jdbcType=VARCHAR},",
          "org_code = #{orgCode,jdbcType=VARCHAR},",
          "lv = #{lv,jdbcType=TINYINT},",
          "pid = #{pid,jdbcType=BIGINT},",
          "org_path = #{orgPath,jdbcType=VARCHAR},",
          "sn = #{sn,jdbcType=SMALLINT},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIME},",
          "state = #{state,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysOrg record);
}