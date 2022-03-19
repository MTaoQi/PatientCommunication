package pc.disease.serviceImpl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.About1;
import pc.disease.mapper.About1Mapper;
import pc.disease.service.About1Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;

import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-03 10:36:07
 */
@Service
public class About1ServiceImpl extends ServiceImpl<About1Mapper, About1> implements About1Service {
    @Autowired
    About1Mapper about1Mapper;
    @Override
    public PcResultutil tp() {
        return PcResultutil.ok(about1Mapper.selectList(new QueryWrapper<>()));
    }
}
