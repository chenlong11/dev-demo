package cn.ksource.domain.attachment;

import cn.ksource.util.ContextUtil;
import cn.ksource.util.UidUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

public class SysAttachmentDto extends SysAttachment implements Serializable {
    
    private static final long serialVersionUID = -7384607601330500076L;

    public static SysAttachmentDto domain2dto(SysAttachment domain) {
        SysAttachmentDto dto = new SysAttachmentDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static SysAttachment dto2domain(SysAttachmentDto dto) {
        SysAttachment domain = new SysAttachment();
        BeanUtils.copyProperties(dto, domain);
        if (domain.getId() == null) {
            domain.setId(UidUtils.getUID());
            domain.setCreateDate(new Date());
            domain.setCreateTime(new Date());
            domain.setCreateId(ContextUtil.getLoginUserId());
            domain.setState(Byte.valueOf("1"));
        }
        return domain;
    }
}
