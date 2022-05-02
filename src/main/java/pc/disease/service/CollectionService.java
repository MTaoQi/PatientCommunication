package pc.disease.service;

import pc.disease.entity.Collection;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-27 12:58:11
 */
public interface CollectionService extends IService<Collection> {

    PcResultutil iscollection(String userid, String communicationid);

    PcResultutil istcollection(String userid, String communicationid);
}
