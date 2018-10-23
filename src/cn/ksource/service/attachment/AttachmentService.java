package cn.ksource.service.attachment;

import cn.ksource.domain.attachment.SysAttachmentDto;
import cn.ksource.domain.response.EditorResult;
import cn.ksource.domain.response.ResponseResult;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface AttachmentService {

    /**
     * 编辑器文件上传
     * @param file
     * @return
     */
    EditorResult uploadEditorImg(CommonsMultipartFile file);

    /**
     * webupload 文件上传
     * @param file
     * @return
     */
    ResponseResult uploadFile(CommonsMultipartFile file);

    /**
     * 保存附件信息
     * @param businessId
     * @param uploadParams
     */
    void save(Long businessId, String uploadParams);

    /**
     * 根据业务id删除附件信息
     * @param businessId
     */
    void delByBusinessId(Long businessId);

    /**
     * 根据业务id获取附件
     * @param businessId
     * @return
     */
    List<SysAttachmentDto> getListByBusinessId(Long businessId);
}
