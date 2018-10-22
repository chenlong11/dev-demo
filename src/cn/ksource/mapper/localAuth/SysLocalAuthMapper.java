package cn.ksource.mapper.localAuth;

import cn.ksource.domain.localAuth.SysLocalAuth;
import cn.ksource.domain.localAuth.SysLocalAuthExample;
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

public interface SysLocalAuthMapper {
    @SelectProvider(type=SysLocalAuthSqlProvider.class, method="countByExample")
    long countByExample(SysLocalAuthExample example);

    @DeleteProvider(type=SysLocalAuthSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysLocalAuthExample example);

    @Delete({
        "delete from sys_local_auth",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_local_auth (id, user_id, ",
        "account_type, account_name, ",
        "account_password, state)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{accountType,jdbcType=TINYINT}, #{accountName,jdbcType=VARCHAR}, ",
        "#{accountPassword,jdbcType=VARCHAR}, #{state,jdbcType=TINYINT})"
    })
    int insert(SysLocalAuth record);

    @InsertProvider(type=SysLocalAuthSqlProvider.class, method="insertSelective")
    int insertSelective(SysLocalAuth record);

    @SelectProvider(type=SysLocalAuthSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="account_type", property="accountType", jdbcType=JdbcType.TINYINT),
        @Result(column="account_name", property="accountName", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_password", property="accountPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    List<SysLocalAuth> selectByExample(SysLocalAuthExample example);

    @Select({
        "select",
        "id, user_id, account_type, account_name, account_password, state",
        "from sys_local_auth",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="account_type", property="accountType", jdbcType=JdbcType.TINYINT),
        @Result(column="account_name", property="accountName", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_password", property="accountPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    SysLocalAuth selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysLocalAuthSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysLocalAuth record, @Param("example") SysLocalAuthExample example);

    @UpdateProvider(type=SysLocalAuthSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysLocalAuth record, @Param("example") SysLocalAuthExample example);

    @UpdateProvider(type=SysLocalAuthSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysLocalAuth record);

    @Update({
        "update sys_local_auth",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "account_type = #{accountType,jdbcType=TINYINT},",
          "account_name = #{accountName,jdbcType=VARCHAR},",
          "account_password = #{accountPassword,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysLocalAuth record);
}