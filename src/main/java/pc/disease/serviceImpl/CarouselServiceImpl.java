package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Carousel;
import pc.disease.mapper.CarouselMapper;
import pc.disease.service.CarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-03 10:36:08
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
    @Autowired
    CarouselMapper carouselMapper;

    @Override
    public PcResultutil pic() {
        List<Carousel> list = carouselMapper.selectList(new QueryWrapper<Carousel>());
        ArrayList<Object> list1 = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            Map<String, Object> map = new HashMap<>();
            //获得下标为i的元素对象
            Carousel c =list.get(i);
            System.out.println(c.getName());
            map.put("carouselid",c.getCarouselid());
            map.put("name",c.getName());
            map.put("src",c.getSrc());
            map.put("createtime",c.getCreatetime());
            map.put("isvaild",c.getIsvalid());
            list1.add(map);

        }
        return PcResultutil.ok(list1);
    }
//    @Override
//    public List pic() {
//        QueryWrapper<Carousel> wrapper = new QueryWrapper<>();
//        List<Carousel> list = carouselMapper.selectList(wrapper);
//        List<Object> list1 = new ArrayList<>();
//        System.out.print(list);
//        for(int i =0;i<list.size();i++){
//            Map<String, Object> map = new HashMap<>();
//            //获得下标为i的元素对象
//            Carousel c =list.get(i);
//            System.out.println(c.getName());
//            map.put("carouselid",c.getCarouselid());
//            map.put("name",c.getName());
//            map.put("src",c.getSrc());
//            map.put("createtime",c.getCreatetime());
//            map.put("isvaild",c.getIsvalid());
//            list1.add(map);
//
//        }
//        return list1;
//    }
}
