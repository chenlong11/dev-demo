package cn.ksource.domain.org;

import cn.ksource.util.UidUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysOrgDto extends SysOrg implements Serializable{
    
    private static final long serialVersionUID = 8952064737773394088L;

    public static SysOrgDto domain2dto(SysOrg domain) {
        SysOrgDto dto = new SysOrgDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysOrg dto2domain(SysOrgDto dto) {
        SysOrg domain = new SysOrg();
        BeanUtils.copyProperties(dto, domain);
        if(dto.getId() == null){
            domain.setId(UidUtils.getUID());
            domain.setCreateDate(new Date());
            domain.setCreateTime(new Date());
            domain.setState(Byte.valueOf("1"));
        }
        return domain;
    }
    
}