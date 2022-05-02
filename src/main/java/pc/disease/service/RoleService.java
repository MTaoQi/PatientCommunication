package pc.disease.service;

import pc.disease.entity.Role;
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
public interface RoleService extends IService<Role> {

    PcResultutil sel(String userid);
}
