package pc.disease.serviceImpl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;


import pc.disease.entity.Feel;
import pc.disease.mapper.FeelMapper;
import pc.disease.service.FeelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import pc.utils.PcResultutil;
import pc.utils.TimeUtil;


import java.util.NavigableMap;
import java.util.TreeMap;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-19 07:40:10
 */
@Service

//开启对定时任务的支持g
public class FeelServiceImpl extends ServiceImpl<FeelMapper, Feel> implements FeelService {
    @Autowired
    FeelMapper feelMapper;
    // 今天我感觉01234
    @Override
    public PcResultutil selmood(String mood) {
        System.out.println(StpUtil.getExtra("userid"));
        String userid= String.valueOf(StpUtil.getExtra("userid"));
//        System.out.println(feelMapper.selectOne(new QueryWrapper<Communication>().eq("userid",userid)));
        String id = feelMapper.selectOne(new QueryWrapper<Feel>().eq("userid",userid)).getId();
        Feel state = feelMapper.selectById(id);
        String oldmood = state.getPublicationState();
        String[] mooods = oldmood.split(",");
        NavigableMap<String, String> moodMap = new TreeMap<>();
        for (String s: mooods){
            moodMap.put(s.split("=")[0].strip(), s.split("=")[1].strip());
        }
        if (mood != null) {
            String date = new TimeUtil().getFormatDateForThree();
            if (moodMap.get(date) == null) {
                moodMap.pollFirstEntry();//返回并删除map的第一个条目
                moodMap.put(date, mood);
            }
            moodMap.put(date, mood);
            state.setPublicationState(String.valueOf(moodMap).replace("{","").replace("}",""));
            state.setTime(new TimeUtil().getParseDateForSix());
            feelMapper.updateById(state);
        }
        return PcResultutil.ok(state);
    }

}
