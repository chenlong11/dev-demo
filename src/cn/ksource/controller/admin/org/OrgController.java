package cn.ksource.controller.admin.org;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.org.SysOrgDto;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.service.org.OrgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @GetMapping("/treeList")
    public String orgTreeList() {
        return "/admin/org/orgTreeList";
    }

    @PostMapping("/tree")
    @ResponseBody
    public ResponseResult postTree() {
        List<Map> orgsTree = orgService.findOrgTree();
        return new ResponseResult(orgsTree);
    }

    @GetMapping("/list")
    public String list() {
        return "/admin/org/orgList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postlist(Long pid, int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<SysOrgDto> list = orgService.findListByPid(pid);
        return new ResponseResult(new PageInfo<SysOrgDto>(list));
    }

    @GetMapping(value = {"/edit", "/edit/{id}"})
    public String getEdit(@PathVariable(required = false, value = "id") Long id, Model model) {
        SysOrgDto orgDto = new SysOrgDto();
        if (id != null) {
            orgDto = orgService.getById(id);
        }
        model.addAttribute("info", orgDto);
        return "/admin/org/orgEdit";
    }

    @PostMapping(value = {"/edit", "/edit/{id}"})
    @ResponseBody
    public ResponseResult postEdit(@PathVariable(required = false, value = "id") String id, SysOrgDto orgDto) {
        if (StrUtil.isBlank(id)) {
            orgService.save(orgDto);
        } else {
            orgService.update(orgDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult del(@PathVariable("id") Long id) {
        orgService.deleteById(id);
        return new ResponseResult();
    }

}
