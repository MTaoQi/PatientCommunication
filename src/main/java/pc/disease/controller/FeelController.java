package pc.disease.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pc.disease.entity.Feel;
import pc.disease.mapper.FeelMapper;
import pc.disease.service.FeelService;
import pc.utils.PcResultutil;
import pc.utils.TimeUtil;

import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;


/**
 * <p>
 *  前端控制器
 * </p>
 * 我感觉
 * @author lazymxh
 * @since 2022-03-19 07:40:10
 */
@Component
@RestController
@RequestMapping("/disease/feel")
public class FeelController {
    @Autowired
    FeelService feelService;
    @Autowired
    FeelMapper feelMapper;

     //   /selmood=01234 修改
    @GetMapping("/selmood")
    public PcResultutil Selmood(@RequestParam(value = "mood",required = false) String mood){
        return feelService.selmood(mood);
    }
    @Scheduled(cron="0 0 0 * * ?")
    public void scheduledTask() {
        List<Feel> feels = feelMapper.selectList(new QueryWrapper<Feel>());
        for (int i = 0; i <feels.size() ; i++) {
            String[] state = feels.get(i).getPublicationState().split(",");

            NavigableMap<String, String> Map = new TreeMap<>();
            for (String s: state){
                Map.put(s.split("=")[0].strip(), s.split("=")[1].strip());
            }
            String time = new TimeUtil().getFormatDateForThree();
            Map.pollFirstEntry();//返回并删除map的第一个条目
            Map.put(time, "4");
            feels.get(i).setPublicationState(String.valueOf(Map).replace("{","").replace("}",""));
            feels.get(i).setTime(new TimeUtil().getParseDateForSix());
            feelMapper.updateById(feels.get(i));
        }



    }



}
