package pc.disease.service;

import pc.disease.entity.Connected;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-14 09:45:18
 */
public interface ConnectedService extends IService<Connected> {

    PcResultutil ist(Connected connected);

    PcResultutil sel(String mname);

    PcResultutil del(String id);
}
