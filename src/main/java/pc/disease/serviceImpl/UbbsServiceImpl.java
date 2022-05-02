package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Bbs;
import pc.disease.entity.Ubbs;
import pc.disease.mapper.BbsMapper;
import pc.disease.mapper.UbbsMapper;
import pc.disease.service.UbbsService;
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
public class UbbsServiceImpl extends ServiceImpl<UbbsMapper, Ubbs> implements UbbsService {
    @Autowired
    UbbsMapper ubbsMapper;
    @Autowired
    BbsMapper  bbsMapper;
    @Override
    public PcResultutil getsel(String userid) {
        List<Ubbs> ubbs = ubbsMapper.selectList(new QueryWrapper<Ubbs>().eq("userid",userid));
        return PcResultutil.ok(ubbs) ;
    }
   //删除模块增加到其他模块
    @Override
    public PcResultutil del(String id) {
        Ubbs ubbs = ubbsMapper.selectOne(new QueryWrapper<Ubbs>().eq("id", id));
        Bbs bbs = new Bbs();
        bbs.setUserid(ubbs.getUserid());
        bbs.setName(ubbs.getName());
        bbs.setBrief(ubbs.getBrief());
        bbsMapper.insert(bbs);
        ubbsMapper.delete(new QueryWrapper<Ubbs>().eq("id", id));
        return PcResultutil.ok();
    }
}
