package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pc.disease.service.RoleService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-03 10:44:16
 */
@RestController
@RequestMapping("/disease/role")
public class RoleController {
@Autowired
    RoleService roleService;
@GetMapping("/sel")
    public PcResultutil sel(@RequestParam("userid") String userid){
    return roleService.sel(userid);
}
}
