package cn.ksource.controller.admin.demo;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.demo.Demo;
import cn.ksource.domain.demo.DemoDto;
import cn.ksource.domain.demo.DemoExample;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

/**
 * Created by chenlong
 * Date：2018/9/13
 * time：9:11
 */

@Controller
@RequestMapping("/admin/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/list")
    public String list() {
        return "/admin/demo/demoList";
    }

    @GetMapping("/list")
    public ResponseResult postList(DemoExample demoExample) {
        demoService.selectByExample(demoExample);
        return new ResponseResult();
    }

    @GetMapping(value = {"/edit","/edit/{id}"})
    public String getDemoEdit(@PathVariable(required = false) String id){
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

    @PostMapping("/detail/{id}")
    public ResponseEntity postDemo(ServletRequest request) {
        Demo demo = new Demo();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity delDemo(ServletRequest request) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
