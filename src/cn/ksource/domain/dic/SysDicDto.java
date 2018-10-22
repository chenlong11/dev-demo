package cn.ksource.domain.dic;

import cn.ksource.util.UidUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class SysDicDto extends SysDic{

    public static SysDicDto domain2dto(SysDic domain) {
        SysDicDto dto = new SysDicDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysDic dto2domain(SysDicDto dto) {
        SysDic domain = new SysDic();
        BeanUtils.copyProperties(dto, domain);
        if (domain.getId() == null) {
            domain.setId(UidUtils.getUID());
            domain.setCreateDate(new Date());
            domain.setCreateTime(new Date());
            domain.setState(Byte.valueOf("1"));
        }
        return domain;
    }

}