package cn.ksource.controller.admin.attachment;

import cn.ksource.domain.attachment.SysAttachmentDto;
import cn.ksource.domain.response.EditorResult;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.service.attachment.AttachmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin/attachment")
public class AttachmentController {

    @Resource
    private AttachmentService attachmentService;

    @RequestMapping("/uploadEditorImg")
    @ResponseBody
    public EditorResult uploadEditorImg(@RequestParam(value="imgFile") CommonsMultipartFile file) {
        return attachmentService.uploadEditorImg(file);
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public ResponseResult uploadFile(@RequestParam(value="file") CommonsMultipartFile file) {
        return attachmentService.uploadFile(file);
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseResult postList(Long businessId) {
        List<SysAttachmentDto> list = attachmentService.getListByBusinessId(businessId);
        return new ResponseResult(list);
    }

}
