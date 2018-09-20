package ${controllerPackage};

import ${domainPackage}.${domainName}Dto;
import ${domainPackage}.${domainName}Example;
import ${servicePackage}.${domainName}Service;

import cn.hutool.core.util.StrUtil;
import cn.ksource.controller.base.BaseController;
import cn.ksource.domain.response.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("${controllerMapping}")
public class ${domainName}Controller extends BaseController {

    @Autowired
    private ${domainName}Service ${entiryName}Service;

    @GetMapping("/list")
    public String list() {
        return "${controllerMapping}/${entiryName}List";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postList(${domainName}Example ${entiryName}Example, int curPage,int pageSize) {
        PageHelper.startPage(curPage,pageSize);
        List<${domainName}Dto> ${entiryName}Dtos = ${entiryName}Service.selectByExample(${entiryName}Example);
        PageInfo<${domainName}Dto> pageInfo = new PageInfo<>(${entiryName}Dtos);
        return new ResponseResult(pageInfo);
    }

    @GetMapping(value = {"/edit","/edit/{id}"})
    public String get${domainName}Edit(@PathVariable(required = false) String id, Model model){
        ${domainName}Dto ${entiryName}Dto = new ${domainName}Dto();
        if (StrUtil.isNotBlank(id)) {
            ${entiryName}Dto = ${entiryName}Service.get${domainName}ById(id);
        }
        model.addAttribute("info", ${entiryName}Dto);
        return "${controllerMapping}/${entiryName}Edit";
    }

    @PostMapping(value = {"/edit","/edit/{id}"})
    @ResponseBody
    public ResponseResult post${domainName}Edit(@PathVariable(required = false) String id, ${domainName}Dto ${entiryName}Dto){
        if (StrUtil.isBlank(id)) {
            ${entiryName}Service.save${domainName}(${entiryName}Dto);
        }else {
            ${entiryName}Service.update${domainName}(${entiryName}Dto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult del${domainName}(@PathVariable String id) {
        ${entiryName}Service.delete${domainName}ById(id);
        return new ResponseResult();
    }

}
