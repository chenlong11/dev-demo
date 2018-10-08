package cn.ksource.mapper.sysModule;

import cn.ksource.domain.sysModule.SysModuleDto;
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
            " and c.user_id = #{userId,jdbcType=VARCHAR}  order by sn asc, create_date asc ")
    List<SysModuleDto> selectListByUserId(String userId);

    @Select({
            "select",
            "id, module_code, module_name, module_url, pid, lv, module_type, sn, create_date, state",
            "from sys_module where state = #{state,jdbcType=TINYINT} order by sn asc, create_date asc "
    })
    List<SysModuleDto> selectAllByState(Integer state);

    @Select({
        "select",
        "id, module_code, module_name, module_url, pid, lv, module_type, sn, create_date, state",
        "from sys_module where pid = #{pid,jdbcType=VARCHAR} and state = 1 order by sn asc, create_date asc "
    })
    List<SysModuleDto> selectListByPid(String pid);
}
