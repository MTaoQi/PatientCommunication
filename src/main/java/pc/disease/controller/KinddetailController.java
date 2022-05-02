package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pc.disease.entity.Kinddetail;

import pc.disease.service.KinddetailService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-02 01:54:59
 */
@RestController
@RequestMapping("/disease/kinddetail")
public class KinddetailController {
    @Autowired
    KinddetailService kinddetailService;
    @RequestMapping("/istKindDetail")
    public PcResultutil istKindDetail(@RequestBody Kinddetail kinddetail){
        return kinddetailService.istKindDetail(kinddetail);
    }
    @GetMapping("/selKindDetail")
    public PcResultutil selKindDetail(@RequestParam("minkind") String minkind){
        return kinddetailService.selKindDetail(minkind);

    }
    @GetMapping("/searchDisease")
    public PcResultutil searchDisease(@RequestParam("keywordDis") String minkind){
        return kinddetailService.searchDisease(minkind);
    }
    @GetMapping("/num")
    public PcResultutil num(){
        return kinddetailService.num();
    }

}
