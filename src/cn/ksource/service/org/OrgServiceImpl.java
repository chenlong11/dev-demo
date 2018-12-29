package cn.ksource.service.org;

import cn.hutool.core.util.RandomUtil;
import cn.ksource.domain.org.SysOrg;
import cn.ksource.domain.org.SysOrgDto;
import cn.ksource.domain.org.SysOrgExample;
import cn.ksource.initialize.InitProcessor;
import cn.ksource.mapper.org.SysOrgManager;
import cn.ksource.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:37
 */
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private SysOrgManager orgManager;

    @Override
    public List<SysOrgDto> findAllByStatus(Integer status) {
        ArrayList<SysOrgDto> sysOrgDtos = new ArrayList<>();

        SysOrgExample sysOrgExample = new SysOrgExample();
        SysOrgExample.Criteria criteria = sysOrgExample.createCriteria();
        criteria.andStateEqualTo(Byte.valueOf("1"));
        sysOrgExample.setOrderByClause("lv asc,sn asc");
        List<SysOrg> sysOrgs = orgManager.selectByExample(sysOrgExample);
        for (SysOrg sysOrg : sysOrgs) {
            sysOrgDtos.add(SysOrgDto.domain2dto(sysOrg));
        }
        return sysOrgDtos;
    }

    @Override
    public List<Map> findOrgTree() {
        return TreeUtil.createTreeByList(findAllByStatus(1));
    }


    private List<SysOrg> getListByPid(Long pid) {
        SysOrgExample sysOrgExample = new SysOrgExample();
        SysOrgExample.Criteria criteria = sysOrgExample.createCriteria();
        criteria.andPidEqualTo(pid);
        criteria.andStateEqualTo(Byte.valueOf("1"));
        sysOrgExample.setOrderByClause(" create_date desc ");
        return orgManager.selectByExample(sysOrgExample);
    }

    @Override
    public SysOrgDto getById(Long id) {
        SysOrg sysOrg = orgManager.selectByPrimaryKey(id);
        return SysOrgDto.domain2dto(sysOrg);
    }

    @Override
    public Long save(SysOrgDto orgDto) {
        SysOrg sysOrg = SysOrgDto.dto2domain(orgDto);
        String systemCode = RandomUtil.randomNumbers(6);

        if (sysOrg.getPid().equals(-1L)) {
            sysOrg.setOrgPath(systemCode);
        } else {
            SysOrg p = orgManager.selectByPrimaryKey(sysOrg.getPid());
            sysOrg.setLv1Id(p.getLv1Id());
            sysOrg.setLv1Name(p.getLv1Name());
            sysOrg.setLv2Id(p.getLv2Id());
            sysOrg.setLv2Name(p.getLv2Name());
            sysOrg.setLv3Id(p.getLv3Id());
            sysOrg.setLv3Name(p.getLv2Name());
            sysOrg.setOrgPath(p.getOrgPath() + ":" + systemCode);
        }

        if (sysOrg.getLv().intValue() == 1) {
            sysOrg.setLv1Id(sysOrg.getId());
            sysOrg.setLv1Name(sysOrg.getOrgName());
        }
        if (sysOrg.getLv().intValue() == 2) {
            sysOrg.setLv2Id(sysOrg.getId());
            sysOrg.setLv2Name(sysOrg.getOrgName());
        }
        if (sysOrg.getLv().intValue() == 3) {
            sysOrg.setLv3Id(sysOrg.getId());
            sysOrg.setLv3Name(sysOrg.getOrgName());
        }

        orgManager.insertSelective(sysOrg);
        InitProcessor.initMenuSet();
        return sysOrg.getId();
    }


    @Override
    public void update(SysOrgDto orgDto) {
        orgManager.updateByPrimaryKeySelective(SysOrgDto.dto2domain(orgDto));
        SysOrg sysOrg = orgManager.selectByPrimaryKey(orgDto.getId());
        updateNameOnChildren(sysOrg.getOrgName(), sysOrg.getLv(), sysOrg.getOrgPath());
        InitProcessor.initMenuSet();
    }

    private void updateNameOnChildren(String orgName, Byte lv, String orgPath) {
        SysOrg sysOrg = new SysOrg();
        if (lv.intValue() == 1) {
            sysOrg.setLv1Name(orgName);
        } else if (lv.intValue() == 2) {
            sysOrg.setLv2Name(orgName);
        } else if (lv.intValue() == 3) {
            sysOrg.setLv3Name(orgName);
        }
        SysOrgExample sysOrgExample = new SysOrgExample();
        SysOrgExample.Criteria criteria = sysOrgExample.createCriteria();
        criteria.andOrgPathLike(orgPath + '%');
        orgManager.updateByExampleSelective(sysOrg, sysOrgExample);
    }

    @Override
    public void deleteById(Long id) {
        orgManager.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> findOrgTreeByUserId(Long userId) {
        SysOrgDto org = orgManager.getListByUserId(userId);
        SysOrgExample sysOrgExample = new SysOrgExample();
        SysOrgExample.Criteria criteria = sysOrgExample.createCriteria();
        criteria.andOrgPathLike(org.getOrgPath() + "%")
            .andStateEqualTo(Byte.valueOf("1"));
        sysOrgExample.setOrderByClause(" lv asc,sn asc ");

        return TreeUtil.createTreeByList(orgManager.selectByExample(sysOrgExample));
    }

    @Override
    public List<SysOrgDto> findListByPid(Long pid) {
        return orgManager.getListByPid(pid);
    }

}
