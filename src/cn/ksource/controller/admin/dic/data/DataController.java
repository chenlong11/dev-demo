package cn.ksource.controller.admin.dic.data;

import cn.hutool.core.util.StrUtil;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.domain.dicData.SysDicDataDto;
import cn.ksource.service.dic.SysDicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/dic/{dicId}/data")
public class DataController {

    @Autowired
    private SysDicService dicService;

    @GetMapping("list")
    public String list(@PathVariable("dicId") String dicId, Model model) {
        model.addAttribute("dicId", dicId);
        return "/admin/dic/data/dataList";
    }

    @PostMapping("/list")
    @ResponseBody
    public ResponseResult postList(@PathVariable("dicId") Long dicId, int curPage, int pageSize) {
        PageHelper.startPage(curPage, pageSize);
        List<SysDicDataDto> list = dicService.getDataListByDicId(dicId);
        PageInfo<SysDicDataDto> pageInfo = new PageInfo<SysDicDataDto>(list);
        return new ResponseResult(pageInfo);
    }

    @GetMapping(value = {"/edit", "/edit/{id}"})
    public String getEdit(@PathVariable(required = false, value = "dicId") String dicId,
                              @PathVariable(required = false, value = "id") Long id,
                              Model model) {
        SysDicDataDto dataDto = new SysDicDataDto();
        if (id != null) {
            dataDto = dicService.getDicDataById(id);
        }
        model.addAttribute("info", dataDto);
        model.addAttribute("dicId", dicId);
        return "/admin/dic/data/dataEdit";
    }

    @PostMapping(value = {"/edit", "/edit/{id}"})
    @ResponseBody
    public ResponseResult postEdit(@PathVariable(required = false, value = "id") String id, SysDicDataDto dataDto) {
        if (StrUtil.isBlank(id)) {
            dicService.saveDicData(dataDto);
        } else {
            dicService.updateDicData(dataDto);
        }
        return new ResponseResult();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public ResponseResult del(@PathVariable("id") Long id) {
        dicService.delDicDataById(id);
        return new ResponseResult();
    }

}
