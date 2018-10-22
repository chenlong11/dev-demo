package cn.ksource.domain.dept;

import cn.ksource.domain.user.SysUserDto;
import cn.ksource.util.UidUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SysDeptDto extends SysDept implements Serializable{

    private static final long serialVersionUID = -3204426760099070806L;

    private List<SysUserDto> users = new ArrayList<SysUserDto>();

    public static SysDeptDto domain2dto(SysDept domain) {
        SysDeptDto dto = new SysDeptDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysDept dto2domain(SysDeptDto dto) {
        SysDept domain = new SysDept();
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
