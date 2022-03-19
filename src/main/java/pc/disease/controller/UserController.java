package pc.disease.controller;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pc.disease.entity.User;
import pc.disease.mapper.UserMapper;
import pc.disease.service.UserService;
import pc.utils.EmailUtil;
import pc.utils.PcResultutil;


import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-01-18 04:10:52
 */
@Data
@RestController
@RequestMapping("/disease/user")
public class UserController {
//
    private final UserMapper userMapper;

    @Autowired
//    @Qualifier("userreg")
    private UserService userService;

    @Autowired
    private EmailUtil emailUtil;


//    注册
    @RequestMapping("/registe")
    public PcResultutil reg(@RequestBody User user) {

        return userService.reg(user);
    }

//    jtw   加密
//    登录
    @RequestMapping("/login")
    public PcResultutil login(@RequestBody User user) {

        return userService.lgn(user);
    }

    @GetMapping("/login2")
    public PcResultutil login2(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userService.lgn(user);
    }
   //邮箱验证码（验证身份）2
    @GetMapping("/sendEmail")
    public String sendEmail(@RequestParam("email") String email) {


        // 验证码随机数
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            result.append(Math.round(Math.random() * 9));
        }
        String code = result.toString();
        emailUtil.sendSimpleTextMail(email, "患者交流", "您正在进行重置密码操作，验证码：" + code);

        return code;
    }
    //忘记密码 邮箱存在返回(确认账号)1
    @RequestMapping("/forgotpwdSelect")
    public PcResultutil forgotpwdSelect(@RequestBody User user){
        return userService.forgotpwdSelect(user);

    }
    //（修改密码）3
    @RequestMapping("/forgotpwdUpdate")
    public PcResultutil forgotpwdUpdate(@RequestBody User user){
        return userService.forgotpwdUpdate(user);
    }

@GetMapping("/getAllUser")
public List<String> selAllUser(){
        return userMapper.selAllUser();
}

}
