package pc.disease.service;

import pc.disease.entity.Ubbs;
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
public interface UbbsService extends IService<Ubbs> {

    PcResultutil getsel(String userid);

    PcResultutil del(String id);
}
