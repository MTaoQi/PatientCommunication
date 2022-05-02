package pc.disease.serviceImpl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.*;
import pc.disease.mapper.*;
import pc.disease.service.CommunicationService;
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
 * @since 2022-03-23 02:55:25
 */
@Service
public class CommunicationServiceImpl extends ServiceImpl<CommunicationMapper, Communication> implements CommunicationService {
    @Autowired
    CommunicationMapper communicationMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    LikesMapper likesMapper;
    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    CommentsMapper commentsMapper;
    @Override
    //用户增加交流
    public PcResultutil write(Communication communication) {
        String titlepc = communication.getTitlepc();
        String contentpc = communication.getContentpc();
        String userid = String.valueOf(StpUtil.getExtra("userid"));
        String username = userMapper.selectOne(new QueryWrapper<User>().eq("userid", userid)).getUsername();
        Communication communication1 = new Communication();
       communication1.setTitlepc(titlepc);
       communication1.setContentpc(contentpc);
       communication1.setUserid(userid);
       communication1.setUsername(username);
       communication1.setTime(new TimeUtil().getParseDateForSix());
        communicationMapper.insert(communication1);
        return PcResultutil.ok(communication1);
    }

    @Override
    //查询所有交流内容
    public PcResultutil selwrite() {
        List<Communication> communications = communicationMapper.selectList(new QueryWrapper<Communication>());
        return PcResultutil.ok(communications);
    }


    @Override
    //删除交流
    public PcResultutil delwrite(String id) {
        communicationMapper.delete(new QueryWrapper<Communication>().eq("id",id));
//        String userid= String.valueOf(StpUtil.getExtra("userid"));
        likesMapper.delete(new QueryWrapper<Likes>().eq("communicationid",id));
        collectionMapper.delete(new QueryWrapper<Collection>().eq("communicationid",id));
        commentsMapper.delete(new QueryWrapper<Comments>().eq("communicationid",id));
        return PcResultutil.ok();
    }

    @Override
    //更新
    public PcResultutil updwrite(Communication communication) {
        communicationMapper.update(communication,new QueryWrapper<Communication>().eq("id",communication.getId()));
        return PcResultutil.ok();
    }

    @Override
    //根据id查询某条记录
    public PcResultutil selidwrite(String id) {
        Communication one = communicationMapper.selectOne(new QueryWrapper<Communication>().eq("id", id));
        return PcResultutil.ok(one);
    }
    //患者所有每日更新（记录）
    @Override
    public PcResultutil usel(String userid) {
        List<Communication> userid1 = communicationMapper.selectList(new QueryWrapper<Communication>().eq("userid", userid));
        return PcResultutil.ok(userid1);
    }


}
