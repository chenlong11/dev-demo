package cn.ksource.controller.admin.index;

import cn.ksource.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenlong
 * Date：2018/9/25
 * time：10:12
 */
@Controller
@RequestMapping("/admin/index")
public class IndexController extends BaseController{

    @GetMapping("/home")
    public String index() {
        return "/admin/index/home";
    }

}
