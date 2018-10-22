package cn.ksource.service.module;


import cn.ksource.domain.module.SysModuleDto;

import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:26
 */
public interface ModuleService {

    List findListByUserId(Long userId);

    List<SysModuleDto> findAll();

    List<SysModuleDto> findAllByStatus(Integer status);

    List<Map> findModuleTree();

    List<SysModuleDto> findListByPid(String pid);

    SysModuleDto getById(Long id);

    Long save(SysModuleDto moduleDto);

    void update(SysModuleDto moduleDto);

    void deleteById(Long id);

    List<SysModuleDto> findListByRoleId(Long roleId);

    List<Map> findModuleTreeByRoleId(Long roleId);

    /**
     * 查询当前机构所能编辑的模块
     * @param orgId
     * @return
     */
    List<Map> findOrgModuleTreeByOrgId(Long orgId);
}
