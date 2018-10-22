package cn.ksource.mapper.moduleRole;

import cn.ksource.domain.moduleRole.SysModuleRole;
import cn.ksource.domain.moduleRole.SysModuleRoleExample;
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

public interface SysModuleRoleMapper {
    @SelectProvider(type=SysModuleRoleSqlProvider.class, method="countByExample")
    long countByExample(SysModuleRoleExample example);

    @DeleteProvider(type=SysModuleRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysModuleRoleExample example);

    @Delete({
        "delete from sys_module_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_module_role (id, role_id, ",
        "module_id)",
        "values (#{id,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT}, ",
        "#{moduleId,jdbcType=BIGINT})"
    })
    int insert(SysModuleRole record);

    @InsertProvider(type=SysModuleRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysModuleRole record);

    @SelectProvider(type=SysModuleRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.BIGINT)
    })
    List<SysModuleRole> selectByExample(SysModuleRoleExample example);

    @Select({
        "select",
        "id, role_id, module_id",
        "from sys_module_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.BIGINT)
    })
    SysModuleRole selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysModuleRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysModuleRole record, @Param("example") SysModuleRoleExample example);

    @UpdateProvider(type=SysModuleRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysModuleRole record, @Param("example") SysModuleRoleExample example);

    @UpdateProvider(type=SysModuleRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysModuleRole record);

    @Update({
        "update sys_module_role",
        "set role_id = #{roleId,jdbcType=BIGINT},",
          "module_id = #{moduleId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysModuleRole record);
}