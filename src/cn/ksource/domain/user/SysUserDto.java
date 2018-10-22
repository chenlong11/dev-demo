package cn.ksource.domain.user;

import cn.ksource.domain.role.SysRoleDto;
import cn.ksource.util.UidUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/9/26
 * time：10:40
 */
@Data
public class SysUserDto extends SysUser implements Serializable {

    private static final long serialVersionUID = 8373740147950625736L;

    private List<SysRoleDto> roles = new ArrayList<SysRoleDto>();

    private List<Map> modules = new ArrayList<Map>();

    public static SysUserDto domain2dto(SysUser domain) {
        SysUserDto dto = new SysUserDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysUser dto2domain(SysUserDto dto) {
        SysUser domain = new SysUser();
        BeanUtils.copyProperties(dto, domain);
        if (dto.getId() == null) {
            domain.setId(UidUtils.getUID());
            domain.setCreateDate(new Date());
            domain.setCreateTime(new Date());
            domain.setState(Byte.valueOf("1"));
        }
        return domain;
    }

}
