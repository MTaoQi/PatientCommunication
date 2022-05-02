package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pc.disease.entity.Kind;
import pc.disease.service.KindService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-02 01:54:58
 */
@RestController
@RequestMapping("/disease/kind")
public class KindController {
@Autowired
KindService kindService;
@RequestMapping("/istkind")
public PcResultutil istkind(@RequestBody Kind kind){
    return kindService.istkind(kind);
}
@GetMapping("/selkind")
public PcResultutil selkind(){
    return kindService.selkind();

}
@GetMapping("/num")
    public PcResultutil getnum(){
    return kindService.getnum();
}
}
