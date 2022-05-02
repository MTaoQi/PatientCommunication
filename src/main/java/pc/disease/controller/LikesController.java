package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pc.disease.service.LikesService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 * 点赞
 * @author lazymxh
 * @since 2022-03-23 11:47:39
 */
@RestController
@RequestMapping("/disease/like")
public class LikesController {
    @Autowired
    LikesService likeservice;
    @GetMapping("/islike")
    public PcResultutil islike(@RequestParam("communicationid") String communicationid) {
        return likeservice.islike(communicationid);

    }
    @GetMapping("/istlike")
    public PcResultutil istlike(@RequestParam("communicationid") String communicationid,@RequestParam("userid") String userid){
        return likeservice.lstlike(communicationid,userid);
    }

}
