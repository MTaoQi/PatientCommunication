package pc.disease.service;

import pc.disease.entity.Communication;
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
public interface CommunicationService extends IService<Communication> {

   PcResultutil selmood(String mood);
}
