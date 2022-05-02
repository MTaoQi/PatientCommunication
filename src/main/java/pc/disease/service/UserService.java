package pc.disease.service;

import pc.disease.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import pc.utils.PcResultutil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-01-18 04:10:52
 */
public interface UserService extends IService<User> {

    PcResultutil reg(User user);

    PcResultutil lgn(User user);


    PcResultutil forgotpwdSelect(User user);

    PcResultutil forgotpwdUpdate(User user);

    PcResultutil getUname(String userid);

    PcResultutil getnum();

    PcResultutil care();
}
