package cn.ksource.controller.admin.role;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.dept.SysDeptDto;
import cn.ksource.domain.module.SysModuleDto;
import cn.ksource.domain.org.SysOrgDto;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.domain.role.SysRoleDto;
import cn.ksource.domain.user.SysUserDto;
import cn.ksource.service.module.ModuleService;
import cn.ksource.service.org.OrgService;
import cn.ksource.service.role.RoleService;
import cn.ksource.service.user.UserService;
import cn.ksource.util.ContextUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private OrgService orgService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private UserService userService;

    @GetMapping("/orgTreeList")
    public String roleTreeList() {
        return "/admin/role/orgTreeList";
    }

    @PostMapping("/orgTree")
    @ResponseBody
    public ResponseResult postTree() {
        List<Map> rolesTree = orgService.findOrgTreeByUserId(ContextUtil.getLoginUserId());
        return new ResponseResult(rolesTree);
    }

    @GetMapping("/orgList")
    public String orgList() {
        return "/admin/role/orgList";
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
        return "/admin/role/roleList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postlist(Long orgId, int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<SysRoleDto> roles = roleService.findListByOrgId(orgId);
        PageInfo<SysRoleDto> pageInfo = new PageInfo<SysRoleDto>(roles);
        return new ResponseResult(pageInfo);
    }

    @GetMapping(value = {"/edit", "/edit/{id}"})
    public String getEdit(@PathVariable(required = false, value = "id") Long id, Model model) {
        SysRoleDto roleDto = new SysRoleDto();
        if (id != null) {
            roleDto = roleService.getById(id);
        }
        model.addAttribute("info", roleDto);
        return "/admin/role/roleEdit";
    }

    @PostMapping(value = {"/edit", "/edit/{id}"})
    @ResponseBody
    public ResponseResult postEdit(@PathVariable(required = false, value = "id") String id, SysRoleDto roleDto) {
        if (StrUtil.isBlank(id)) {
            roleService.save(roleDto);
        } else {
            roleService.update(roleDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult del(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return new ResponseResult();
    }

    @GetMapping("{id}/module")
    public String module(@PathVariable("id") Long id, Long orgId, Model model) {
        List<Map> modulelist = new ArrayList<Map>();
        if (orgId == null) {//查询所有模块
            modulelist = moduleService.findModuleTree();
        }else{
            modulelist = moduleService.findOrgModuleTreeByOrgId(orgId);
        }

        List<SysModuleDto> roleModulelist = moduleService.findListByRoleId(id);
        model.addAttribute("modulelist", modulelist);
        model.addAttribute("roleModulelist", JSON.toJSONString(roleModulelist));
        model.addAttribute("id", id);
        return "/admin/role/module";
    }

    @PostMapping("{id}/module")
    @ResponseBody
    public ResponseResult postModule(@PathVariable("id") Long roleId, @RequestParam(value = "moduleId[]",required=false) Long[] moduleIds) {
        roleService.saveModule(moduleIds, roleId);
        return new ResponseResult();
    }

    @GetMapping("{id}/user")
    public String user(@PathVariable("id") Long id, Long orgId, Model model) {
        List<SysDeptDto> depts = userService.findDeptAndUserByOrgId(orgId);
        List<SysUserDto> roleUserlist = userService.findListByRoleId(id);
        model.addAttribute("depts", depts);
        model.addAttribute("roleUserlist", JSON.toJSONString(roleUserlist));
        model.addAttribute("id", id);
        return "/admin/role/user";
    }

    @PostMapping("{id}/user")
    @ResponseBody
    public ResponseResult postUser(@PathVariable("id") Long roleId, @RequestParam(value = "userId[]",required=false) Long[] userId) {
        roleService.saveUser(userId, roleId);
        return new ResponseResult();
    }

    @GetMapping("/reserveList")
    public String roleReserveList() {
        return "/admin/role/roleReserveList";
    }

    @PostMapping("/reserveList")
    @ResponseBody
    public ResponseResult reserveList(Long orgId, int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<SysRoleDto> roles = roleService.findReserveList();
        PageInfo<SysRoleDto> pageInfo = new PageInfo<SysRoleDto>(roles);
        return new ResponseResult(pageInfo);
    }

}
