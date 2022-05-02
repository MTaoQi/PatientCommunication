package pc.disease.service;

import pc.disease.entity.Treatdetail;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-03 10:44:16
 */
public interface TreatdetailService extends IService<Treatdetail> {

    PcResultutil istTreatdetail(Treatdetail treatdetail);

    PcResultutil selTreatdetail(String typ);

    PcResultutil search(String keyword);
}
