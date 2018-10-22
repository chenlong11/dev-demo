package cn.ksource.mapper.module;

import cn.ksource.domain.module.SysModuleDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:30
 */
public interface SysModuleManager extends SysModuleMapper {

    /**
     * 查找用户模块
     * @param userId
     * @return
     */
    @Select(" select a.id, a.module_code, a.module_name, a.module_url, a.pid, a.lv, a.module_type, a.sn " +
            " from sys_module a,sys_module_role b,sys_user_role c  " +
            " where " +
            " a.id = b.module_id and b.role_id = c.role_id " +
            " and c.user_id = #{userId,jdbcType=BIGINT} group by a.id order by sn asc, create_date asc ")
    List<SysModuleDto> selectListByUserId(Long userId);

    @Select({
            "select",
            "id, module_code, module_name, module_url, pid, lv, module_type, sn, create_date, create_time, state",
            "from sys_module where state = #{state,jdbcType=TINYINT} order by lv asc, sn asc "
    })
    List<SysModuleDto> selectAllByState(Integer state);

    @Select({
        "select",
        "id, module_code, module_name, module_url, pid, lv, module_type, sn, create_date, create_time, state",
        "from sys_module where pid = #{pid,jdbcType=BIGINT} and state = 1 order by sn asc, create_date asc "
    })
    List<SysModuleDto> selectListByPid(String pid);

    @Select({
            "select",
            "a.id, a.module_code, a.module_name, a.module_url, a.pid, a.lv, a.module_type, a.sn, a.create_date, a.state",
            "from sys_module a, sys_module_role b where a.id = b.module_id ",
            "and  b.role_id = #{roleId,jdbcType=BIGINT} and state = 1",
            "order by sn asc, create_date asc "
    })
    List<SysModuleDto> findListByRoleId(Long roleId);
}
