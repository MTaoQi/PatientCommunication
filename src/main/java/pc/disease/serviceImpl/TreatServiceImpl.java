package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Treat;
import pc.disease.mapper.TreatMapper;
import pc.disease.service.TreatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-03 10:44:16
 */
@Service
public class TreatServiceImpl extends ServiceImpl<TreatMapper, Treat> implements TreatService {
    @Autowired
    TreatMapper treatMapper;
    @Override
    public PcResultutil istTreat(Treat treat) {
        treatMapper.insert(treat);
        return PcResultutil.ok(treat);
    }

    @Override
    public PcResultutil selTreat() {
        List<Treat> treats = treatMapper.selectList(new QueryWrapper<Treat>());
        return PcResultutil.ok(treats);
    }
    //治疗主类数量
    @Override
    public PcResultutil getnum() {
        int count = Math.toIntExact(treatMapper.selectCount(new QueryWrapper<Treat>()));
        return PcResultutil.ok(count);
    }
}
