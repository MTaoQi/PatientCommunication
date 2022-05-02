package pc.disease.serviceImpl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Report;
import pc.disease.entity.User;
import pc.disease.mapper.ReportMapper;
import pc.disease.mapper.UserMapper;
import pc.disease.service.ReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;
import pc.utils.TimeUtil;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-15 10:58:01
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {
    @Autowired
    ReportMapper reportMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    //举报
    public PcResultutil ist(Report report) {
        String userid = String.valueOf(StpUtil.getExtra("userid"));
        boolean exists = reportMapper.exists(new QueryWrapper<Report>().eq("userid", userid).eq("conid", report.getConid()));
        if(exists==false) {
            report.setUserid(userid);
            String email = userMapper.selectOne(new QueryWrapper<User>().eq("userid", userid)).getEmail();
            report.setEmail(email);
            report.setTime(new TimeUtil().getParseDateForSix());
            reportMapper.insert(report);
            return PcResultutil.ok(report);
        }
        else{
            return PcResultutil.error(500,"已举报");
        }
    }

    @Override
    //是否举报
    public PcResultutil exi(String userid, String conid) {
        boolean exists = reportMapper.exists(new QueryWrapper<Report>().eq("userid", userid).eq("conid", conid));
        if(exists==true){
            return PcResultutil.ok();
        }
        return PcResultutil.error(500,"未举报");
    }

    @Override
    //查询所有举报帖子
    public PcResultutil sel() {
        List<Report> reports = reportMapper.selectList(new QueryWrapper<Report>());
        return PcResultutil.ok(reports);
    }

    //举报总数
    @Override
    public PcResultutil getnum() {
        int count = Math.toIntExact(reportMapper.selectCount(new QueryWrapper<Report>()));
        return PcResultutil.ok(count);
    }


}
