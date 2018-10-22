package cn.ksource.service.dic;

import cn.ksource.domain.dic.SysDicDto;
import cn.ksource.domain.dic.SysDicExample;
import cn.ksource.domain.dicData.SysDicData;
import cn.ksource.domain.dicData.SysDicDataDto;
import cn.ksource.domain.dicData.SysDicDataExample;
import cn.ksource.mapper.dic.SysDicManager;
import cn.ksource.mapper.dicData.SysDicDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DicServiceImpl implements SysDicService {

    @Autowired
    private SysDicManager dicManager;

    @Autowired
    private SysDicDataManager dicDataManager;

    @Override
    public List<SysDicDto> getDicList() {

        List<SysDicDto> sysDicDtos = new ArrayList<SysDicDto>();

        SysDicExample example = new SysDicExample();
        example.createCriteria().andStateEqualTo(Byte.valueOf("1"));
        List<cn.ksource.domain.dic.SysDic> sysDics = dicManager.selectByExample(example);

        if (sysDics != null) {
            for (cn.ksource.domain.dic.SysDic sysDic : sysDics) {
                sysDicDtos.add(SysDicDto.domain2dto(sysDic));
            }
        }
        return sysDicDtos;
    }

    @Override
    public void saveDic(SysDicDto sysDicDto) {
        dicManager.insertSelective(SysDicDto.dto2domain(sysDicDto));
    }

    @Override
    public void updateDic(SysDicDto sysDicDto) {
        dicManager.updateByPrimaryKeySelective(SysDicDto.dto2domain(sysDicDto));
    }

    @Override
    public void delDicById(Long id) {
        dicManager.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysDicDataDto> getDataListByCode(String dicCode) {
        SysDicDto dicDto = dicManager.getByCode(dicCode);
        return getDataListByDicId(dicDto.getId());
    }

    @Override
    public void saveDicData(SysDicDataDto sysDicDataDto) {
        dicDataManager.insertSelective(SysDicDataDto.dto2domain(sysDicDataDto));
    }

    @Override
    public void delDicDataById(Long id) {
        dicDataManager.deleteByPrimaryKey(id);
    }

    @Override
    public SysDicDto getDicById(Long id) {
        return SysDicDto.domain2dto(dicManager.selectByPrimaryKey(id));
    }

    @Override
    public SysDicDataDto getDicDataById(Long id) {
        SysDicData sysDicData = dicDataManager.selectByPrimaryKey(id);
        return SysDicDataDto.domain2dto(sysDicData);
    }

    @Override
    public void updateDicData(SysDicDataDto dataDto) {
        dicDataManager.updateByPrimaryKeySelective(SysDicDataDto.dto2domain(dataDto));
    }

    @Override
    public List<SysDicDataDto> getDataListByDicId(Long dicId) {
        List<SysDicDataDto> sysDicDataDtos = new ArrayList<SysDicDataDto>();

        SysDicDataExample example = new SysDicDataExample();
        example.createCriteria().andDicIdEqualTo(dicId);
        example.setOrderByClause(" sn asc ");

        List<SysDicData> sysDicDatas = dicDataManager.selectByExample(example);

        if (sysDicDatas != null) {
            for (SysDicData sysDicData : sysDicDatas) {
                sysDicDataDtos.add(SysDicDataDto.domain2dto(sysDicData));
            }
        }
        return sysDicDataDtos;
    }


}
