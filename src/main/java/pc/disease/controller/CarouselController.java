package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pc.disease.entity.Carousel;
import pc.disease.service.CarouselService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-03 10:36:08
 */
@RestController
//轮播图
@RequestMapping("/disease/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    @GetMapping("/pic")
    public List pic(){
        return carouselService.pic();

    }


}
