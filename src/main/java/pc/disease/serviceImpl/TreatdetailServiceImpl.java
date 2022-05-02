package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Treatdetail;
import pc.disease.mapper.TreatdetailMapper;
import pc.disease.service.TreatdetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-03 10:44:16
 */
@Service
public class TreatdetailServiceImpl extends ServiceImpl<TreatdetailMapper, Treatdetail> implements TreatdetailService {
    @Autowired
    TreatdetailMapper treatdetailMapper;
    @Override
    public PcResultutil istTreatdetail(Treatdetail treatdetail) {
        treatdetailMapper.insert(treatdetail);
        return PcResultutil.ok(treatdetail);
    }

    @Override
    public PcResultutil selTreatdetail(String typ) {
        Treatdetail typ1 = treatdetailMapper.selectOne(new QueryWrapper<Treatdetail>().eq("typ", typ));
        return PcResultutil.ok(typ1);
    }
     //搜索治疗关键词
    @Override
    public PcResultutil search(String keyword) {
        Treatdetail s = treatdetailMapper.selectOne(new QueryWrapper<Treatdetail>().like("typ", keyword));
        return PcResultutil.ok(s);
    }
}
