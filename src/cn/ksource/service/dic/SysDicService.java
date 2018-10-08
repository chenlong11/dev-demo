package cn.ksource.service.dic;

import cn.ksource.domain.sysDic.SysDicDto;
import cn.ksource.domain.sysDicData.SysDicDataDto;

import java.util.List;

public interface SysDicService {

    List<SysDicDto> getDicList();

    void saveDic(SysDicDto sysDicDto);

    void updateDic(SysDicDto sysDicDto);

    void delDicById(String id);

    List<SysDicDataDto> getDataListByCode(String dicCode);

    void saveDicData(SysDicDataDto sysDicDataDto);

    void delDicDataById(String id);

    SysDicDto getDicById(String id);
}
