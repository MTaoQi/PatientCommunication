package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pc.disease.entity.Treatdetail;
import pc.disease.service.TreatdetailService;
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
@RequestMapping("/disease/treatdetail")
public class TreatdetailController {
    @Autowired
    TreatdetailService treatdetailService;
    @RequestMapping("/istTreatdetail")
        public PcResultutil istTreatdetail(@RequestBody Treatdetail treatdetail){
        return treatdetailService.istTreatdetail(treatdetail);
    }

    @GetMapping("/selTreatdetail")
    public PcResultutil selTreatdetail(@RequestParam("typ") String typ){
        return treatdetailService.selTreatdetail(typ);
    }
    @GetMapping("/Search")
    public PcResultutil Search(@RequestParam("keyword") String keyword){
        return treatdetailService.search(keyword);
    }

}
