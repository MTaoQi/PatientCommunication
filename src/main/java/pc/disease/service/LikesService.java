package pc.disease.service;

import pc.disease.entity.Likes;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-23 11:47:39
 */
public interface LikesService extends IService<Likes> {

    PcResultutil islike(String communicationid);

    PcResultutil lstlike(String communicationid, String userid);
}
