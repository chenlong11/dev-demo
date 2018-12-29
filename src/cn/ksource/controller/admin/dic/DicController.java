package cn.ksource.controller.admin.dic;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.domain.dic.SysDicDto;
import cn.ksource.service.attachment.AttachmentService;
import cn.ksource.service.dic.SysDicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin/dic")
public class DicController {

    @Autowired
    private SysDicService dicService;

    @Resource
    private AttachmentService attachmentService;

    @GetMapping("/list")
    public String list(){
        return "/admin/dic/dicList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postList(int curPage,int pageSize){
        PageHelper.startPage(curPage, pageSize);
        List<SysDicDto> dicList = dicService.getDicList();
        return new ResponseResult(new PageInfo<SysDicDto>(dicList));
    }

    @GetMapping(value = {"/edit","/edit/{id}"})
    public String getEdit(@PathVariable(required = false,value = "id") Long id, Model model){
        SysDicDto dicDto = new SysDicDto();
        if (id != null) {
            dicDto = dicService.getDicById(id);
        }
        model.addAttribute("info", dicDto);
        return "/admin/dic/dicEdit";
    }

    @PostMapping(value = {"/edit","/edit/{id}"})
    @ResponseBody
    public ResponseResult postEdit(@PathVariable(required = false,value = "id") String id, SysDicDto dicDto){
        if (StrUtil.isBlank(id)) {
            dicService.saveDic(dicDto);
        }else {
            dicService.updateDic(dicDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult del(@PathVariable("id") Long id) {
        dicService.delDicById(id);
        return new ResponseResult();
    }

    @PostMapping("/data")
    @ResponseBody
    public ResponseResult getDataByDicCode(String dicCode) {
        return new ResponseResult(dicService.getDataListByCode(dicCode));
    }

}
