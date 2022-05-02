package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Bbs;
import pc.disease.entity.Ubbs;
import pc.disease.mapper.BbsMapper;
import pc.disease.mapper.UbbsMapper;
import pc.disease.service.BbsService;
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
 * @since 2022-04-10 09:40:02
 */
@Service
public class BbsServiceImpl extends ServiceImpl<BbsMapper, Bbs> implements BbsService {
    @Autowired
    BbsMapper bbsMapper;
    @Autowired
    UbbsMapper ubbsMapper;
    @Override
    public PcResultutil sel(String userid) {
        List<Bbs> bbs = bbsMapper.selectList(new QueryWrapper<Bbs>().eq("userid",userid));
        return PcResultutil.ok(bbs);
    }
//    删除其他模块增加到用户模块
    @Override
    public PcResultutil del(String id) {
        Bbs bbs = bbsMapper.selectOne(new QueryWrapper<Bbs>().eq("id", id));
        Ubbs ubbs = new Ubbs();
        ubbs.setUserid(bbs.getUserid());
        ubbs.setName(bbs.getName());
        ubbs.setBrief(bbs.getBrief());
        ubbsMapper.insert(ubbs);
        bbsMapper.delete(new QueryWrapper<Bbs>().eq("id", id));
        return PcResultutil.ok();
    }
}
