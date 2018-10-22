package cn.ksource.service.dic;

import cn.ksource.domain.dic.SysDicDto;
import cn.ksource.domain.dicData.SysDicDataDto;

import java.util.List;

public interface SysDicService {

    List<SysDicDto> getDicList();

    void saveDic(SysDicDto sysDicDto);

    void updateDic(SysDicDto sysDicDto);

    void delDicById(Long id);

    List<SysDicDataDto> getDataListByCode(String dicCode);

    void saveDicData(SysDicDataDto sysDicDataDto);

    void delDicDataById(Long id);

    SysDicDto getDicById(Long id);

    SysDicDataDto getDicDataById(Long id);

    void updateDicData(SysDicDataDto dataDto);

    List<SysDicDataDto> getDataListByDicId(Long dicId);
}
