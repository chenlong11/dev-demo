package cn.ksource.service.org;


import cn.ksource.domain.org.SysOrgDto;

import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:26
 */
public interface OrgService {

    List<SysOrgDto> findAllByStatus(Integer status);

    List<Map> findOrgTree();

    List<SysOrgDto> findListByPid(Long pid);

    SysOrgDto getById(Long id);

    SysOrgDto getByPid(Long pid);

    Long save(SysOrgDto orgDto);

    void update(SysOrgDto orgDto);

    void deleteById(Long id);

    List<Map> findOrgTreeByUserId(Long userId);

}
