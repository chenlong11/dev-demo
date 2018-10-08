package cn.ksource.service.role;

import cn.ksource.domain.sysRole.SysRoleDto;
import cn.ksource.mapper.sysRole.SysRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:17
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleManager sysRoleDao;

    @Override
    public List<SysRoleDto> findByUserId(String id) {
        if (sysRoleDao.findByUserId(id) == null) {
            return new ArrayList<SysRoleDto>();
        }
        return sysRoleDao.findByUserId(id);
    }

}
