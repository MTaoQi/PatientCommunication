package pc.disease.service;

import pc.disease.entity.Bbs;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-10 09:40:02
 */
public interface BbsService extends IService<Bbs> {

    PcResultutil sel(String userid);

    PcResultutil del(String id);
}
