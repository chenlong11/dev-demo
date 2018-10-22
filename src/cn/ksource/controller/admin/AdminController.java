package cn.ksource.controller.admin;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;
import cn.ksource.constants.Constants;
import cn.ksource.domain.response.ResponseResult;
import cn.ksource.service.LocalAuth.LocalAuthService;
import cn.ksource.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private LocalAuthService sysLocalAuthService;

    @GetMapping("/login")
    public String login() {
        return "/admin/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseResult postLogin(String username, String password, String code) {
        //得到原始password
        byte[] decode = Base64.decode(password);
        AES aes = new AES(Mode.CBC, Padding.PKCS5Padding, Constants.AES_KEY.getBytes(),  Constants.AES_IV.getBytes());
        return sysLocalAuthService.localauth(username,  aes.decryptStr(decode), code);
    }

    @GetMapping("/loginFailure")
    public String LoginFailure() {
        return "/admin/loginFailure";
    }

    @GetMapping("/logout")
    public String logout() {
        ContextUtil.clearAdminSession();
        return "redirect:/admin/login";
    }

    @GetMapping("/nopermission")
    public String nopermission() {
        return "/admin/nopermission";
    }

}
