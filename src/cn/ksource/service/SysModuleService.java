package cn.ksource.service;


import cn.ksource.domain.sysModule.SysModuleDto;

import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:26
 */
public interface SysModuleService {

    List findListByUserId(String userId);

    List<SysModuleDto> findAll();

    List<SysModuleDto> findAllByStatus(Integer status);

    List<Map> findModuleTree();

    List<SysModuleDto> findListByPid(String pid);

    SysModuleDto getById(String id);

    String save(SysModuleDto moduleDto);

    void update(SysModuleDto moduleDto);

    void deleteById(String id);
}
