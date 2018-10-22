package cn.ksource.domain.dicData;

import cn.ksource.util.UidUtils;
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
        if (dto.getId() == null) {
            domain.setId(UidUtils.getUID());
        }
        return domain;
    }

}