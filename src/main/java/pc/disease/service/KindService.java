package pc.disease.service;

import pc.disease.entity.Kind;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-02 01:54:58
 */
public interface KindService extends IService<Kind> {

    PcResultutil istkind(Kind kind);

    PcResultutil selkind();

    PcResultutil getnum();
}
