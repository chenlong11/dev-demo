package cn.ksource.mapper.org;

import cn.ksource.domain.org.SysOrgDto;
import org.apache.ibatis.annotations.Select;

public interface SysOrgManager extends SysOrgMapper {

    @Select({
            "select",
            "id, lv1_id, lv1_name, lv2_id, lv2_name, lv3_id, lv3_name, org_name, org_code, ",
            "lv, pid, org_path, sn, create_date, create_time, state",
            "from sys_org",
            "where pid = #{id,jdbcType=BIGINT}"
    })
    SysOrgDto getByPid(Long pid);

    @Select({
            "select",
            "g.id, g.lv1_id, g.lv1_name, g.lv2_id, g.lv2_name, g.lv3_id, g.lv3_name, g.org_name, g.org_code, ",
            "g.lv, g.pid, g.org_path, g.sn, g.create_date, g.create_time, g.state",
            "from sys_org g, sys_user u",
            "where g.id = u.org_id and u.id = #{id,jdbcType=BIGINT}"
    })
    SysOrgDto getListByUserId(Long userId);
}
