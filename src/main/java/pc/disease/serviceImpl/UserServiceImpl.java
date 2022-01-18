package pc.disease.serviceImpl;

import pc.disease.entity.User;
import pc.disease.mapper.UserMapper;
import pc.disease.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-01-18 04:10:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
