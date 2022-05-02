package pc.disease.service;

import pc.disease.entity.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-27 12:58:12
 */
public interface CommentsService extends IService<Comments> {

    PcResultutil istcomment(Comments comments);

    PcResultutil selcomment(String communicationid);


    PcResultutil delcomment(String replyid);

    PcResultutil numcomment(String communicationid);
}
