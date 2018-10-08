package cn.ksource.controller.admin.dic;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.domain.sysDic.SysDicDto;
import cn.ksource.service.dic.SysDicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/dic")
public class DicController {

    @Autowired
    private SysDicService dicService;

    @GetMapping("/list")
    public String list(){
        return "/admin/dic/dicList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postList(int curPage,int pageSize){
        PageHelper.startPage(curPage, pageSize);
        List<SysDicDto> dicList = dicService.getDicList();
        PageInfo<SysDicDto> pageInfo = new PageInfo<SysDicDto>(dicList);
        return new ResponseResult(pageInfo);
    }

    @GetMapping(value = {"/edit","/edit/{id}"})
    public String getDemoEdit(@PathVariable(required = false) String id, Model model){
        SysDicDto dicDto = new SysDicDto();
        if (StrUtil.isNotBlank(id)) {
            dicDto = dicService.getDicById(id);
        }
        model.addAttribute("info", dicDto);
        return "/admin/dic/dicEdit";
    }

    @PostMapping(value = {"/edit","/edit/{id}"})
    @ResponseBody
    public ResponseResult postDemoEdit(@PathVariable(required = false) String id, SysDicDto dicDto){
        if (StrUtil.isBlank(id)) {
            dicService.saveDic(dicDto);
        }else {
            dicService.updateDic(dicDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult delDemo(@PathVariable String id) {
        dicService.delDicById(id);
        return new ResponseResult();
    }

}
