package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pc.disease.service.UbbsService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-10 09:40:02
 */
@RestController
@RequestMapping("/disease/ubbs")
public class UbbsController {
    @Autowired
    UbbsService ubbsService;
    @GetMapping("/sel")
    public PcResultutil sel(@RequestParam("userid") String userid){
        return ubbsService.getsel(userid);
    }
    @GetMapping("/del")
    public PcResultutil del(@RequestParam("id") String id){
        return ubbsService.del(id);
    }
}
