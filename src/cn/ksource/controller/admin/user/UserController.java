package cn.ksource.controller.admin.user;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.org.SysOrgDto;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.domain.user.SysUserDto;
import cn.ksource.service.dept.DeptService;
import cn.ksource.service.org.OrgService;
import cn.ksource.service.user.UserService;
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
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrgService orgService;

    @Autowired
    private DeptService deptService;

    @GetMapping("/orgTreeList")
    public String userTreeList() {
        return "/admin/user/orgTreeList";
    }

    @PostMapping("/orgTree")
    @ResponseBody
    public ResponseResult postTree() {
        List<Map> usersTree = orgService.findOrgTreeByUserId(ContextUtil.getLoginUserId());
        return new ResponseResult(usersTree);
    }

    @GetMapping("/orgList")
    public String orgList() {
        return "/admin/user/orgList";
    }

    @PostMapping("/orgList")
    @ResponseBody
    public ResponseResult postOrgList(Long pid, int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<SysOrgDto> orgs = orgService.findListByPid(pid);
        PageInfo<SysOrgDto> pageInfo = new PageInfo<SysOrgDto>(orgs);
        return new ResponseResult(pageInfo);
    }


    @GetMapping("/treeList")
    public String treeList() {
        return "/admin/user/userTreeList";
    }

    @PostMapping("/deptTree")
    @ResponseBody
    public ResponseResult deptTree(Long orgId) {
        List<Map> deptTree = deptService.findTreeByOrgId(orgId);
        return new ResponseResult(deptTree);
    }

    @GetMapping("/list")
    public String list() {
        return "/admin/user/userList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postlist(Long orgId, Long deptId, int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<SysUserDto> users = userService.findListByOrgAndDeptId(orgId,deptId);
        PageInfo<SysUserDto> pageInfo = new PageInfo<SysUserDto>(users);
        return new ResponseResult(pageInfo);
    }

    @GetMapping(value = {"/edit", "/edit/{id}"})
    public String getEdit(@PathVariable(required = false, value = "id") Long id, Model model) {
        SysUserDto userDto = new SysUserDto();
        if (id != null) {
            userDto = userService.getById(id);
        }
        model.addAttribute("info", userDto);
        return "/admin/user/userEdit";
    }

    @PostMapping(value = {"/edit", "/edit/{id}"})
    @ResponseBody
    public ResponseResult postEdit(@PathVariable(required = false, value = "id") String id, SysUserDto userDto) {
        if (StrUtil.isBlank(id)) {
            userService.save(userDto);
        } else {
            userService.update(userDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult del(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ResponseResult();
    }

    @PostMapping("/isAccountExist")
    @ResponseBody
    public boolean isAccountExist(String accountName,Long id) {
        return userService.isAccountExist(accountName,id);
    }

}
