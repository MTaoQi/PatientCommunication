package pc.disease.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import pc.disease.entity.About1;
import pc.disease.service.About1Service;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-03 10:36:07
 */

@RestController
@RequestMapping("/disease/about1")
public class About1Controller {
    @Autowired
    About1Service about1Service;

   @GetMapping("/getTextpic1")
    public PcResultutil getTextpic() {
       return about1Service.tp();
    }

}
