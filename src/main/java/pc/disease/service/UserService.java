package pc.disease.service;

import pc.disease.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lazymxh
 * @since 2022-01-18 04:10:52
 */
public interface UserService extends IService<User> {

    Map reg(User user);

    Map lgn(User user);


    Map forgotpwdSelect(User user);

    Map forgotpwdUpdate(User user);

}
