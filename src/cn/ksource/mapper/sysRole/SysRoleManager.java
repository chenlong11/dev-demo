package cn.ksource.mapper.sysRole;

import cn.ksource.domain.sysRole.SysRoleDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:10
 */
public interface SysRoleManager extends SysRoleMapper{

    @Select({
            "select",
            "a.id, a.role_name, a.role_code, a.sn, a.create_date, a.state",
            "from sys_role a,sys_user_role b",
            "where a.id = b.role_id and b.user_id = #{userId,jdbcType=INTEGER}"
    })
    List<SysRoleDto> findByUserId(String userId);
}
