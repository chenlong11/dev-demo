package cn.ksource.domain.module;

import cn.ksource.util.UidUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：23:31
 */
@Data
public class SysModuleDto extends SysModule implements Serializable {

    private static final long serialVersionUID = 2563220120370548013L;

    public static SysModuleDto domain2dto(SysModule domain) {
        SysModuleDto dto = new SysModuleDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysModule dto2domain(SysModuleDto dto) {
        SysModule domain = new SysModule();
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
