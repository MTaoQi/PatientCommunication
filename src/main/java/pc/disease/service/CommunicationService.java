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
 * @since 2022-03-23 02:55:25
 */
public interface CommunicationService extends IService<Communication> {

    PcResultutil write(Communication communication);


    PcResultutil selwrite();

    PcResultutil delwrite(String id);

    PcResultutil updwrite(Communication communication);

    PcResultutil selidwrite(String id);

    PcResultutil usel(String userid);
}
