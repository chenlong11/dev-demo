package cn.ksource.domain.sysDicData;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class SysDicDataDto extends SysDicData {

    public static SysDicDataDto domain2dto(SysDicData domain) {
        SysDicDataDto dto = new SysDicDataDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysDicData dto2domain(SysDicDataDto dto) {
        SysDicData domain = new SysDicData();
        BeanUtils.copyProperties(dto, domain);
        return domain;
    }

}