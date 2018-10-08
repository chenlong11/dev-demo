package cn.ksource.domain.sysDic;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class SysDicDto {

    private String id;

    private String dicName;

    private String dicCode;

    private Short sn;

    private Date createDate;

    public static SysDicDto domain2dto(SysDic domain) {
        SysDicDto dto = new SysDicDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysDic dto2domain(SysDicDto dto) {
        SysDic domain = new SysDic();
        BeanUtils.copyProperties(dto, domain);
        if (StrUtil.isBlank(domain.getId())) {
            domain.setId(RandomUtil.simpleUUID());
            domain.setCreateDate(new Date());
            domain.setCreateTime(new Date());
            domain.setState(Byte.valueOf("1"));
        }
        return domain;
    }

}