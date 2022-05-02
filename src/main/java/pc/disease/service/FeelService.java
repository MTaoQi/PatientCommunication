package pc.disease.service;

import pc.disease.entity.Feel;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-03-19 07:40:10
 */
public interface FeelService extends IService<Feel> {

   PcResultutil selmood(String mood);

}
