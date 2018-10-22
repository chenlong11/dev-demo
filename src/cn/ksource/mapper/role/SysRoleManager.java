package cn.ksource.mapper.role;

import cn.ksource.domain.role.SysRoleDto;
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
            "where a.id = b.role_id and b.user_id = #{userId,jdbcType=BIGINT}"
    })
    List<SysRoleDto> findByUserId(Long userId);

    @Select({
            "select count(*)",
            "from sys_role a,sys_user_role b",
            "where a.id = b.role_id and b.user_id = #{userId,jdbcType=BIGINT} and a.role_code = 'super'"
    })
    long selectSuperCountByUserId(Long userId);
}
