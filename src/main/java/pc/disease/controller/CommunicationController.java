package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pc.disease.entity.Communication;
import pc.disease.mapper.CommunicationMapper;
import pc.disease.service.CommunicationService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 * 交流
 * @author lazymxh
 * @since 2022-03-23 02:55:25
 */
@RestController
@RequestMapping("/disease/communication")
public class CommunicationController {
    @Autowired
    CommunicationService communicationService;
    @RequestMapping("/instwrite")
    public PcResultutil insertcontent(@RequestBody Communication communication){
        return communicationService.write(communication);
    }
    @GetMapping("/selwrite")
    public PcResultutil selfcontent(){
        return communicationService.selwrite();
    }


    @GetMapping("/delwrite")
    public PcResultutil delcontent(@RequestParam("id") String id){
        return communicationService.delwrite(id);
    }
    @RequestMapping("/updwrite")
    public PcResultutil updcontent(@RequestBody Communication communication){
        return communicationService.updwrite(communication);
    }
    @GetMapping("/selidwrite")
    public PcResultutil selidwrite(@RequestParam("id") String id){
        return communicationService.selidwrite(id);
    }

    @GetMapping("/usel")
    public PcResultutil sel(@RequestParam("userid") String userid){
        return communicationService.usel(userid);
    }

}
