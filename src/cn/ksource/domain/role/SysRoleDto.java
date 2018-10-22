package cn.ksource.domain.role;

import cn.ksource.util.UidUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:11
 */
public class SysRoleDto extends SysRole implements Serializable{

    private static final long serialVersionUID = 610214701993455853L;

    public static SysRoleDto domain2dto(SysRole domain) {
        SysRoleDto dto = new SysRoleDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysRole dto2domain(SysRoleDto dto) {
        SysRole domain = new SysRole();
        BeanUtils.copyProperties(dto, domain);
        if(dto.getId()==null){
            domain.setId(UidUtils.getUID());
            domain.setCreateDate(new Date());
            domain.setCreateTime(new Date());
            domain.setState(Byte.valueOf("1"));
        }
        return domain;
    }
    
}
