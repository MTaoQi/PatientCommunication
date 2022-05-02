package pc.disease.serviceImpl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Connected;
import pc.disease.entity.User;
import pc.disease.mapper.ConnectedMapper;
import pc.disease.mapper.UserMapper;
import pc.disease.service.ConnectedService;
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
 * @since 2022-04-14 09:45:18
 */
@Service
public class ConnectedServiceImpl extends ServiceImpl<ConnectedMapper, Connected> implements ConnectedService {
    @Autowired
    ConnectedMapper connectedMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    //插入模块
    public PcResultutil ist(Connected connected) {
        String tit = connected.getTit();
        String con = connected.getCon();
        String userid = String.valueOf(StpUtil.getExtra("userid"));
        String username = userMapper.selectOne(new QueryWrapper<User>().eq("userid", userid)).getUsername();
        String mname = connected.getMname();
        Connected connected1 = new Connected();
        connected1.setTit(tit);
        connected1.setCon(con);
        connected1.setUserid(userid);
        connected1.setUsername(username);
        connected1.setMname(mname);
        connected1.setTime(new TimeUtil().getParseDateForSix());
        connectedMapper.insert(connected1);
        return PcResultutil.ok(connected1);
    }

    @Override
    public PcResultutil sel(String mname) {
        List<Connected> mname1 = connectedMapper.selectList(new QueryWrapper<Connected>().eq("mname", mname));
        return PcResultutil.ok(mname1);
    }
    //删除违规帖子
    @Override
    public PcResultutil del(String id) {
        int i = connectedMapper.delete(new QueryWrapper<Connected>().eq("id", id));
        if(i==1){
            return PcResultutil.ok();
        }
        return PcResultutil.error(500,"删除失败");
    }
}
