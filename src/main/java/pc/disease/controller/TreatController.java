package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pc.disease.entity.Treat;
import pc.disease.service.TreatService;
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
@RequestMapping("/disease/treat")
public class TreatController {
    @Autowired
    TreatService treatService;
    @RequestMapping("/istTreat")
    public PcResultutil istTreat(@RequestBody Treat treat){
        return treatService.istTreat(treat);
    }
    @GetMapping("/selTreat")
    public PcResultutil selTreat(){
        return treatService.selTreat();
    }
    @GetMapping("/num")
        public PcResultutil getnum(){
            return treatService.getnum();
        }


}
