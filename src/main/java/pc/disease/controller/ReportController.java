package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pc.disease.entity.Report;
import pc.disease.service.ReportService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-15 10:58:01
 */
@RestController
@RequestMapping("/disease/report")
public class ReportController {
@Autowired
    ReportService reportService;
@RequestMapping("/ist")
    public PcResultutil ist(@RequestBody Report report){
    return reportService.ist(report);
}
@GetMapping("/exi")
    public PcResultutil exi(@RequestParam("userid") String userid,@RequestParam("conid") String conid){
    return reportService.exi(userid,conid);
}
@GetMapping("/sel")
    public PcResultutil sel(){
    return reportService.sel();
}
@GetMapping("/num")
    public PcResultutil getnum(){
    return reportService.getnum();
}
}

