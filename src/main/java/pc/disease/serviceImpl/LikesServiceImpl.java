package pc.disease.serviceImpl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Communication;
import pc.disease.entity.Likes;
import pc.disease.mapper.CommunicationMapper;
import pc.disease.mapper.LikesMapper;
import pc.disease.service.LikesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;
import pc.utils.TimeUtil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-23 11:47:39
 */
@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements LikesService {
    @Autowired
    LikesMapper likesMapper;
    @Autowired
    CommunicationMapper communicationMapper;
    @Override
    //用户是否点赞
    public PcResultutil islike(String communicationid) {
        String id= String.valueOf(StpUtil.getExtra("userid"));
        int count = likesMapper.selectCount(new QueryWrapper<Likes>().eq("communicationid", communicationid).eq("userid", id)).intValue();
        if (count!=1){
            //没点赞
            return PcResultutil.ok("no");
        }
        return PcResultutil.ok("yes");
    }

    @Override
    //点赞
    public PcResultutil lstlike(String communicationid, String userid) {
        int count = likesMapper.selectCount(new QueryWrapper<Likes>().eq("communicationid", communicationid).eq("userid", userid)).intValue();
        if( count == 1){
            likesMapper.delete(new QueryWrapper<Likes>().eq("communicationid",communicationid).eq("userid",userid));
        }
        else{
            Likes likes = new Likes();
            likes.setCommunicationid(communicationid);
            likes.setUserid(userid);
            likes.setTime(new TimeUtil().getParseDateForSix());
            likesMapper.insert(likes);
        }
        int num= Math.toIntExact(likesMapper.selectCount(new QueryWrapper<Likes>().eq("communicationid", communicationid)));
        Communication communication = new Communication();
        communication.setId(communicationid);
        communication.setNumlike(num);
        communicationMapper.update(communication,new QueryWrapper<Communication>().eq("id",communicationid));
        return PcResultutil.ok(num);
    }
}
