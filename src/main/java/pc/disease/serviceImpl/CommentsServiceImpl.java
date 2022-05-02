package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Comments;
import pc.disease.entity.Communication;
import pc.disease.mapper.CommentsMapper;
import pc.disease.mapper.CommunicationMapper;
import pc.disease.service.CommentsService;
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
 * @since 2022-03-27 12:58:12
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {
    @Autowired
    CommentsMapper commentsMapper;
    @Autowired
    CommunicationMapper communicationMapper;

    @Override
    //增加评论
    public PcResultutil istcomment(Comments comments) {
        int rec = commentsMapper.insert(comments);
        if(rec!=1){
            return PcResultutil.error(500,"评论失败");
        }
        return PcResultutil.ok(comments);
    }


    @Override
    //查询所有评论
    public PcResultutil selcomment(String communicationid) {
        List<Comments> list = commentsMapper.selectList(new QueryWrapper<Comments>().eq("communicationid", communicationid));
        return PcResultutil.ok(list);
    }

    @Override
    //删除评论
    public PcResultutil delcomment(String replyid) {
        commentsMapper.delete(new QueryWrapper<Comments>().eq("replyid",replyid));
        return PcResultutil.ok();
    }
    //查询回复数量
    @Override
    public PcResultutil numcomment(String communicationid) {
        int count = Math.toIntExact(commentsMapper.selectCount(new QueryWrapper<Comments>().eq("communicationid", communicationid)));
        return PcResultutil.ok(count);
    }


}
