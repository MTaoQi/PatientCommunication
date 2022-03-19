package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.About2;
import pc.disease.mapper.About2Mapper;
import pc.disease.mapper.UserMapper;
import pc.disease.service.About2Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-03 10:36:08
 */
@Service
public class About2ServiceImpl extends ServiceImpl<About2Mapper, About2> implements About2Service {
    @Autowired
    About2Mapper about2Mapper;
    @Override
    public PcResultutil about2Servicetp2() {

        return PcResultutil.ok(about2Mapper.selectList(new QueryWrapper<>()));
    }
}
