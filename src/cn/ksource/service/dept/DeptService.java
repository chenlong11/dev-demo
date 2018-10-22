package cn.ksource.service.dept;

import cn.ksource.domain.dept.SysDeptDto;

import java.util.List;
import java.util.Map;

public interface DeptService {

    SysDeptDto getById(Long id);

    void save(SysDeptDto deptDto);

    void update(SysDeptDto deptDto);

    void delById(Long id);

    List<SysDeptDto> findListByOrgId(Long orgId);

    List<Map> findTreeByOrgId(Long orgId);
}
