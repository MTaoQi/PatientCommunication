package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pc.disease.entity.Connected;
import pc.disease.service.ConnectedService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-14 09:45:18
 */
@RestController
@RequestMapping("/disease/connected")
public class ConnectedController {
    @Autowired
    ConnectedService connectedService;
    @RequestMapping("/ist")
    public PcResultutil ist(@RequestBody Connected connected){
        return connectedService.ist(connected);
    }
    @GetMapping("/sel")
    public PcResultutil sel(@RequestParam("mname") String mname ){
        return connectedService.sel(mname);
    }
    @GetMapping("/del")
    public PcResultutil del(@RequestParam("id") String id){
        return connectedService.del(id);
    }

}
