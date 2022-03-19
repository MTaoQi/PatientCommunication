package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pc.disease.service.About2Service;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-03 10:36:08
 */
@RestController
@RequestMapping("/disease/about2")
public class About2Controller {
    @Autowired
    About2Service about2Service;
    @GetMapping("/getTextpic2")
    public PcResultutil getTextpic2(){
        return about2Service.about2Servicetp2();
    }

}
