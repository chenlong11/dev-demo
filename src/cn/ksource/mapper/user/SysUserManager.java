package cn.ksource.mapper.user;

import cn.ksource.domain.user.SysUserDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:04
 */
public interface SysUserManager extends SysUserMapper{

    @Select({
            "select",
            "a.id, a.org_id, a.dept_id, a.user_name, a.account_name, a.mobile_no, a.email, a.sn, a.create_date, ",
            "a.create_time, a.state",
            "from sys_user a ,sys_user_role b",
            "where a.id = b.user_id and b.role_id = #{roleId,jdbcType=BIGINT}"
    })
    List<SysUserDto> findListByRoleId(Long roleId);

}
