package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pc.disease.service.CollectionService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *  收藏
 * @author lazymxh
 * @since 2022-03-27 12:58:11
 */
@RestController
@RequestMapping("/disease/collection")
public class CollectionController {
    @Autowired
    CollectionService collectionService;
    @GetMapping("/iscollection")
    public PcResultutil iscollection(@RequestParam("userid") String userid,@RequestParam("communicationid") String communicationid) {
        return collectionService.iscollection(userid,communicationid);
    }
    @GetMapping("/istcollection")
    public PcResultutil istcollection(@RequestParam("userid") String userid,@RequestParam("communicationid") String communicationid){
        return collectionService.istcollection(userid,communicationid);
    }



}
