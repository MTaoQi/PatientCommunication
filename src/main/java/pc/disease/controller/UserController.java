package pc.disease.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-01-18 04:10:52
 */
@RestController
@RequestMapping("/disease/user")
public class UserController {
    public String hello(){
        return "hello spring boot!";
    }
}
