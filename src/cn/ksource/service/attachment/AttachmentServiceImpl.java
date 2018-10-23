package cn.ksource.service.attachment;

import cn.hutool.core.util.StrUtil;
import cn.ksource.constants.Constants;
import cn.ksource.domain.attachment.SysAttachment;
import cn.ksource.domain.attachment.SysAttachmentDto;
import cn.ksource.domain.attachment.SysAttachmentExample;
import cn.ksource.domain.response.EditorResult;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.exception.NotAllowFileTypeException;
import cn.ksource.mapper.attachment.SysAttachmentManager;
import cn.ksource.util.UploadUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Resource
    private SysAttachmentManager attachmentManager;

    @Override
    public EditorResult uploadEditorImg(CommonsMultipartFile file) {
        try {
            String ext = UploadUtil.getFileExt(file.getOriginalFilename());
            if (!UploadUtil.isAllowExtension(ext)) {
                return new EditorResult(1,"不允许的文件格式");
            }
            String fileName = UploadUtil.getRelativeFileName(ext);
            file.transferTo(new File(UploadUtil.getApplicationPath() + fileName));
            return new EditorResult(Constants.CONTEXT_PATH + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new EditorResult(1,"上传出错");
        }
    }

    @Override
    public ResponseResult uploadFile(CommonsMultipartFile file) {
        SysAttachmentDto sysAttachment = new SysAttachmentDto();
        String ext = UploadUtil.getFileExt(file.getOriginalFilename());
        if (!UploadUtil.isAllowExtension(ext)) {
            throw new NotAllowFileTypeException("不支持的文件类型");
        }
        String relativeFileName = UploadUtil.getRelativeFileName(ext);
        try {
            //保存文件
            file.transferTo(new File(UploadUtil.getApplicationPath() + relativeFileName));
            sysAttachment.setAttName(file.getOriginalFilename());
            sysAttachment.setAttPath(relativeFileName);
            sysAttachment.setAttSize(String.valueOf(file.getSize()));
            sysAttachment.setAttExt(ext);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseResult(sysAttachment);
    }

    @Override
    public void save(Long businessId, String uploadParams) {
        //删除已有附件
        delByBusinessId(businessId);

        if (StrUtil.isBlank(uploadParams)) {
            return;
        }

        List<SysAttachmentDto> sysAttachmentDtos = JSON.parseArray(uploadParams, SysAttachmentDto.class);
        for (SysAttachmentDto sysAttachmentDto : sysAttachmentDtos) {
            sysAttachmentDto.setBusinessId(businessId);
            attachmentManager.insertSelective(SysAttachmentDto.dto2domain(sysAttachmentDto));
        }
    }

    @Override
    public void delByBusinessId(Long businessId) {
        SysAttachmentExample example = new SysAttachmentExample();
        SysAttachmentExample.Criteria criteria = example.createCriteria();
        criteria.andBusinessIdEqualTo(businessId);
        attachmentManager.deleteByExample(example);

    }

    @Override
    public List<SysAttachmentDto> getListByBusinessId(Long businessId) {

        List<SysAttachmentDto> list = new ArrayList<SysAttachmentDto>();

        SysAttachmentExample example = new SysAttachmentExample();
        SysAttachmentExample.Criteria criteria = example.createCriteria();
        criteria.andBusinessIdEqualTo(businessId)
                .andStateEqualTo(Byte.valueOf("1"));
        List<SysAttachment> sysAttachments = attachmentManager.selectByExample(example);
        for (SysAttachment sysAttachment : sysAttachments) {
            list.add(SysAttachmentDto.domain2dto(sysAttachment));
        }
        return list;
    }


}
