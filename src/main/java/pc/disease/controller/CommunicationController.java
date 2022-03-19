package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pc.disease.entity.Communication;
import pc.disease.service.CommunicationService;
import pc.utils.PcResultutil;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-19 07:40:10
 */

@RestController
@RequestMapping("/disease/communication")
public class CommunicationController {
    @Autowired
    CommunicationService communicationService;
    @GetMapping("/selmood")
    public PcResultutil Selmood(@RequestParam(value = "mood",required = false) String mood){


        return communicationService.selmood(mood);
    }

}
