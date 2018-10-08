package cn.ksource.service.dic;

import cn.ksource.domain.sysDic.SysDicDto;
import cn.ksource.domain.sysDic.SysDicExample;
import cn.ksource.domain.sysDicData.SysDicData;
import cn.ksource.domain.sysDicData.SysDicDataDto;
import cn.ksource.domain.sysDicData.SysDicDataExample;
import cn.ksource.mapper.sysDic.SysDicManager;
import cn.ksource.mapper.sysDicData.SysDicDataManager;
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
        List<cn.ksource.domain.sysDic.SysDic> sysDics = dicManager.selectByExample(example);

        if (sysDics != null) {
            for (cn.ksource.domain.sysDic.SysDic sysDic : sysDics) {
                sysDicDtos.add(SysDicDto.domain2dto(sysDic));
            }
        }
        return sysDicDtos;
    }

    @Override
    public void saveDic(SysDicDto sysDicDto) {
        dicManager.insert(SysDicDto.dto2domain(sysDicDto));
    }

    @Override
    public void updateDic(SysDicDto sysDicDto) {
        dicManager.updateByPrimaryKeySelective(SysDicDto.dto2domain(sysDicDto));
    }

    @Override
    public void delDicById(String id) {
        dicManager.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysDicDataDto> getDataListByCode(String dicCode) {
        List<SysDicDataDto> sysDicDataDtos = new ArrayList<SysDicDataDto>();

        List<SysDicData> sysDicDatas = dicDataManager.selectByExample(new SysDicDataExample());

        if (sysDicDatas != null) {
            for (SysDicData sysDicData : sysDicDatas) {
                sysDicDataDtos.add(SysDicDataDto.domain2dto(sysDicData));
            }
        }
        return sysDicDataDtos;
    }

    @Override
    public void saveDicData(SysDicDataDto sysDicDataDto) {
        dicDataManager.insert(SysDicDataDto.dto2domain(sysDicDataDto));
    }

    @Override
    public void delDicDataById(String id) {
        dicDataManager.deleteByPrimaryKey(id);
    }

    @Override
    public SysDicDto getDicById(String id) {
        return SysDicDto.domain2dto(dicManager.selectByPrimaryKey(id));
    }


}
