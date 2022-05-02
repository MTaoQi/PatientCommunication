package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Kind;
import pc.disease.mapper.KindMapper;
import pc.disease.service.KindService;
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
 * @since 2022-04-02 01:54:58
 */
@Service
public class KindServiceImpl extends ServiceImpl<KindMapper, Kind> implements KindService {
    @Autowired
    KindMapper kindMapper;
    //插入类型 wei
    @Override
    public PcResultutil istkind(Kind kind) {
        kindMapper.insert(kind);
        return PcResultutil.ok(kind);
    }
    //查询类型
    @Override
    public PcResultutil selkind() {
        List<Kind> kindList = kindMapper.selectList(new QueryWrapper<Kind>());
        return PcResultutil.ok(kindList);
    }
    //种类主类数量
    @Override
    public PcResultutil getnum() {
        int count = Math.toIntExact(kindMapper.selectCount(new QueryWrapper<Kind>()));
        return PcResultutil.ok(count);
    }
}
