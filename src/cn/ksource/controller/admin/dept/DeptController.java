package cn.ksource.controller.admin.dept;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.dept.SysDeptDto;
import cn.ksource.domain.org.SysOrgDto;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.service.dept.DeptService;
import cn.ksource.service.org.OrgService;
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
@RequestMapping("/admin/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private OrgService orgService;


    @GetMapping("/orgTreeList")
    public String deptTreeList() {
        return "/admin/dept/orgTreeList";
    }

    @PostMapping("/orgTree")
    @ResponseBody
    public ResponseResult postTree() {
        List<Map> deptsTree = orgService.findOrgTreeByUserId(ContextUtil.getLoginUserId());
        return new ResponseResult(deptsTree);
    }

    @GetMapping("/orgList")
    public String orgList() {
        return "/admin/dept/orgList";
    }

    @PostMapping("/orgList")
    @ResponseBody
    public ResponseResult postOrgList(Long pid, int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<SysOrgDto> list = orgService.findListByPid(pid);
        return new ResponseResult(new PageInfo<SysOrgDto>(list));
    }

    @GetMapping("/list")
    public String list() {
        return "/admin/dept/deptList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postlist(Long orgId, int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<SysDeptDto> depts = deptService.findListByOrgId(orgId);
        PageInfo<SysDeptDto> pageInfo = new PageInfo<SysDeptDto>(depts);
        return new ResponseResult(pageInfo);
    }

    @GetMapping(value = {"/edit", "/edit/{id}"})
    public String getEdit(@PathVariable(required = false, value = "id") Long id, Model model) {
        SysDeptDto deptDto = new SysDeptDto();
        if (id != null) {
            deptDto = deptService.getById(id);
        }
        model.addAttribute("info", deptDto);
        return "/admin/dept/deptEdit";
    }

    @PostMapping(value = {"/edit", "/edit/{id}"})
    @ResponseBody
    public ResponseResult postEdit(@PathVariable(required = false, value = "id") String id, SysDeptDto deptDto) {
        if (StrUtil.isBlank(id)) {
            deptService.save(deptDto);
        } else {
            deptService.update(deptDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult del(@PathVariable("id") Long id) {
        deptService.delById(id);
        return new ResponseResult();
    }
    
}
