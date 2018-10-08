package cn.ksource.controller.admin.demo;

import cn.hutool.core.util.StrUtil;
import cn.ksource.controller.base.BaseController;
import cn.ksource.domain.demo.DemoDto;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.service.demo.DemoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/9/13
 * time：9:11
 */

@Controller
@RequestMapping("/admin/demo")
public class DemoController extends BaseController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/list")
    public String list() {
        return "/admin/demo/demoList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postList(DemoDto demoDto, int curPage,int pageSize) {
        PageHelper.startPage(curPage,pageSize);
        List<DemoDto> demoDtos = demoService.selectByExample(demoDto);
        PageInfo<DemoDto> pageInfo = new PageInfo<DemoDto>(demoDtos);
        return new ResponseResult(pageInfo);
    }

    @GetMapping(value = {"/edit","/edit/{id}"})
    public String getDemoEdit(@PathVariable(required = false) String id, Model model){
        DemoDto demoDto = new DemoDto();
        if (StrUtil.isNotBlank(id)) {
            demoDto = demoService.getDemoById(id);
        }
        model.addAttribute("info", demoDto);
        return "/admin/demo/demoEdit";
    }

    @PostMapping(value = {"/edit","/edit/{id}"})
    @ResponseBody
    public ResponseResult postDemoEdit(@PathVariable(required = false) String id, DemoDto demoDto){
        if (StrUtil.isBlank(id)) {
            demoService.saveDemo(demoDto);
        }else {
            demoService.updateDemo(demoDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult delDemo(@PathVariable String id) {
        demoService.deleteDemoById(id);
        return new ResponseResult();
    }


}
