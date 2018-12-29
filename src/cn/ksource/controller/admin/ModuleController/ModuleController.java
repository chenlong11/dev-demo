package cn.ksource.controller.admin.ModuleController;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.module.SysModuleDto;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.initialize.InitProcessor;
import cn.ksource.service.module.ModuleService;
import cn.ksource.util.ContextUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/treeList")
    public String moduleTreeList() {
        return "/admin/module/moduleTreeList";
    }

    @PostMapping("/tree")
    @ResponseBody
    public ResponseResult postTree() {
        List<Map> modulesTree = moduleService.findModuleTree();
        return new ResponseResult(modulesTree);
    }

    @GetMapping("/list")
    public String list() {
        return "/admin/module/moduleList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postlist(String pid,int curPage,int pageSize) {
        PageHelper.startPage(curPage,pageSize);
        List<SysModuleDto> modules = moduleService.findListByPid(pid);
        return new ResponseResult(new PageInfo<SysModuleDto>(modules));
    }

    @GetMapping(value = {"/edit","/edit/{id}"})
    public String getEdit(@PathVariable(required = false,value = "id") Long id, Model model){
        SysModuleDto moduleDto = new SysModuleDto();
        if (id != null) {
            moduleDto = moduleService.getById(id);
        }
        model.addAttribute("info", moduleDto);
        return "/admin/module/moduleEdit";
    }

    @PostMapping(value = {"/edit","/edit/{id}"})
    @ResponseBody
    public ResponseResult postEdit(@PathVariable(required = false,value = "id") String id, SysModuleDto moduleDto){
        if (StrUtil.isBlank(id)) {
            moduleService.save(moduleDto);
        }else {
            moduleService.update(moduleDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult del(@PathVariable("id") Long id) {
        moduleService.deleteById(id);
        return new ResponseResult();
    }

    @GetMapping("/redirect/{lv2ModuleId}")
    public String redirect(@PathVariable("lv2ModuleId") String lv2ModuleId) {
        if (InitProcessor.allModule.containsKey(lv2ModuleId)) {
            String lv2ModuleCode = InitProcessor.allModule.get(lv2ModuleId);
            String lv1moduleCode = lv2ModuleCode.substring(0, lv2ModuleCode.indexOf(":"));
            List<Map> modules = ContextUtil.getLoginUser().getModules();
            for (Map lv1module : modules) {
                if (Convert.toStr(lv1module.get("moduleCode")).equals(lv1moduleCode)) {
                    for (Map lv2module : (List<Map>) lv1module.get("children")) {
                        if (Convert.toStr(lv2module.get("moduleCode")).equals(lv2ModuleCode)
                                && lv2module.get("children") != null
                                && ((List<Map>) lv2module.get("children")).size() > 0) {
                            return "redirect:" + Convert.toStr(((List<Map>) lv2module.get("children")).get(0).get("moduleUrl"));
                        }
                    }
                }
                break;
            }
        }
        return "redirect:/admin/nopermission";
    }

}
