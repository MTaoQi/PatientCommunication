package pc.disease.service;

import pc.disease.entity.Kinddetail;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-02 01:54:59
 */
public interface KinddetailService extends IService<Kinddetail> {

    PcResultutil istKindDetail(Kinddetail kinddetail);

    PcResultutil selKindDetail(String minkind);

    PcResultutil searchDisease(String minkind);

    PcResultutil num();
}
