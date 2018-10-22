package cn.ksource.mapper.localAuth;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:26
 */
public interface SysLocalAuthManager extends SysLocalAuthMapper {

    @Select({"select user_id from sys_local_auth ",
            " where account_name=#{account,jdbcType=VARCHAR} and account_password=#{password,jdbcType=VARCHAR} "})
    public Long authAccount(@Param("account") String account,@Param("password") String password);

}
