package cn.ksource.mapper.dept;

import cn.ksource.domain.dept.SysDeptDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysDeptManager extends SysDeptMapper {

    @Select({
            "select",
            "id, org_id, dept_name, dept_code, lv, pid, sn, create_date, create_time, state",
            "from sys_dept",
            "where state = 1 and org_id = #{orgId,jdbcType=BIGINT} ",
            "order by sn asc, id desc"
    })
    List<SysDeptDto> getListByOrgId(Long orgId);
}
