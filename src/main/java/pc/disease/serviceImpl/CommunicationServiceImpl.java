package pc.disease.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Communication;
import pc.disease.mapper.CommunicationMapper;
import pc.disease.service.CommunicationService;
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
public class CommunicationServiceImpl extends ServiceImpl<CommunicationMapper, Communication> implements CommunicationService {
    @Autowired
    CommunicationMapper communicationMapper;

    @Override
    public PcResultutil selmood(String mood) {

        Communication state = communicationMapper.selectById("11111");
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
            communicationMapper.updateById(state);
        }
        
        return PcResultutil.ok(state);
    }
}
