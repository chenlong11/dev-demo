package cn.ksource.service.user;

import cn.ksource.domain.dept.SysDeptDto;
import cn.ksource.domain.localAuth.SysLocalAuth;
import cn.ksource.domain.user.SysUser;
import cn.ksource.domain.user.SysUserDto;
import cn.ksource.domain.user.SysUserExample;
import cn.ksource.mapper.localAuth.SysLocalAuthManager;
import cn.ksource.mapper.user.SysUserManager;
import cn.ksource.service.dept.DeptService;
import cn.ksource.util.CryptUtil;
import cn.ksource.util.UidUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserManager userManager;

    @Autowired
    private SysLocalAuthManager localAuthManager;

    @Autowired
    private DeptService deptService;


    @Override
    public SysUserDto getById(Long id) {
        SysUser sysUser = userManager.selectByPrimaryKey(id);
        return SysUserDto.domain2dto(sysUser);
    }

    @Override
    public List<SysUserDto> findListByOrgId(Long orgId) {
        List<SysUserDto> sysUserDtos = new ArrayList<>();
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(Byte.valueOf("1"))
                .andOrgIdEqualTo(orgId);
        example.setOrderByClause(" sn asc, id desc ");
        List<SysUser> sysUsers = userManager.selectByExample(example);
        for (SysUser sysUser : sysUsers) {
            sysUserDtos.add(SysUserDto.domain2dto(sysUser));
        }
        return sysUserDtos;
    }

    @Override
    public void save(SysUserDto userDto) {

        SysUser sysUser = SysUserDto.dto2domain(userDto);
        userManager.insertSelective(sysUser);

        SysLocalAuth auth1 = new SysLocalAuth();
        auth1.setId(UidUtils.getUID());
        auth1.setUserId(sysUser.getId());
        auth1.setAccountName(sysUser.getAccountName());
        auth1.setAccountPassword(CryptUtil.getEncryptPassword(sysUser.getAccountName(), sysUser.getAccountName()));
        localAuthManager.insertSelective(auth1);
    }

    @Override
    public void update(SysUserDto userDto) {
        userManager.updateByPrimaryKeySelective(SysUserDto.dto2domain(userDto));
    }

    @Override
    public void deleteById(Long id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setState(Byte.valueOf("0"));
        userManager.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public List<SysDeptDto> findDeptAndUserByOrgId(Long orgId) {

        Map<Long, SysDeptDto> deptSet = new HashedMap<Long, SysDeptDto>();

        List<SysDeptDto> depts = deptService.findListByOrgId(orgId);
        SysDeptDto sysDeptDto = new SysDeptDto();
        sysDeptDto.setId(10000L);
        sysDeptDto.setPid(-1L);
        sysDeptDto.setDeptName("其它");
        depts.add(sysDeptDto);
        for (SysDeptDto dept : depts) {
            deptSet.put(dept.getId(), dept);
        }

        List<SysUserDto> users = findListByOrgId(orgId);
        for (SysUserDto user : users) {
            if(user.getDeptId().equals(-1L)){
                user.setDeptId(10000L);
            }
            if (deptSet.get(user.getDeptId()) != null) {
                deptSet.get(user.getDeptId()).getUsers().add(user);
            }
        }
        return depts;
    }


    @Override
    public List<SysUserDto> findListByRoleId(Long roleId) {
        return userManager.findListByRoleId(roleId);
    }

    @Override
    public boolean isAccountExist(String accountName, Long id) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNameEqualTo(accountName);
        if (id != null) {
            criteria.andIdNotEqualTo(id);
        }
        long count = userManager.countByExample(example);
        if (count <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<SysUserDto> findListByOrgAndDeptId(Long orgId, Long deptId) {
        System.out.println("deptId" + deptId);
        List<SysUserDto> sysUserDtos = new ArrayList<>();
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(Byte.valueOf("1"))
                .andOrgIdEqualTo(orgId)
                .andDeptIdEqualTo(deptId);
        example.setOrderByClause(" sn asc, id desc ");
        List<SysUser> sysUsers = userManager.selectByExample(example);
        for (SysUser sysUser : sysUsers) {
            sysUserDtos.add(SysUserDto.domain2dto(sysUser));
        }
        return sysUserDtos;
    }

}
