package cn.ksource.service.dept;

import cn.ksource.domain.dept.SysDept;
import cn.ksource.domain.dept.SysDeptDto;
import cn.ksource.domain.dept.SysDeptExample;
import cn.ksource.mapper.dept.SysDeptManager;
import cn.ksource.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private SysDeptManager deptManager;

    @Override
    public List<SysDeptDto> findListByOrgId(Long orgId) {
        ArrayList<SysDeptDto> sysDeptDtos = new ArrayList<>();

        SysDeptExample example = new SysDeptExample();
        SysDeptExample.Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        criteria.andStateEqualTo(Byte.valueOf("1"));
        example.setOrderByClause("id desc");

        List<SysDept> sysDepts = deptManager.selectByExample(example);
        if (sysDepts != null) {
            for (SysDept sysDept : sysDepts) {
                sysDeptDtos.add(SysDeptDto.domain2dto(sysDept));
            }
        }
        return sysDeptDtos;
    }

    @Override
    public List<Map> findTreeByOrgId(Long orgId) {
        return TreeUtil.createTreeByList(findListByOrgId(orgId));
    }

    @Override
    public SysDeptDto getById(Long id) {
        return SysDeptDto.domain2dto(deptManager.selectByPrimaryKey(id));
    }

    @Override
    public void save(SysDeptDto deptDto) {
        deptManager.insertSelective(SysDeptDto.dto2domain(deptDto));
    }

    @Override
    public void update(SysDeptDto deptDto) {
        deptManager.updateByPrimaryKeySelective(SysDeptDto.dto2domain(deptDto));
    }

    @Override
    public void delById(Long id) {
        SysDept sysDept = new SysDept();
        sysDept.setId(id);
        sysDept.setState(Byte.valueOf("0"));
        deptManager.updateByPrimaryKeySelective(sysDept);
    }
}
