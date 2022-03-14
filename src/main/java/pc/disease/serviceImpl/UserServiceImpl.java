package pc.disease.serviceImpl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.User;
import pc.disease.mapper.UserMapper;
import pc.disease.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-01-18 04:10:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map reg(User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        boolean user1 = userMapper.exists(new QueryWrapper<User>().eq("username", username).or().eq("email", email));
        //用户不存在 注册
        if (user1 == false ) {
            User user2 = new User();
            user2.setUsername(username);
            user2.setPassword(SaSecureUtil.md5(user.getPassword()));
            user2.setEmail(user.getEmail());
            user2.setIdentity(user.getIdentity());
            user2.setSymptoms(user.getSymptoms());
            userMapper.insert(user2);
            Map<Object, Object> map = new HashMap<>();

            map.put("success", 1);
            return map;
//            User username1 = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
//            return username1;
        }
        //1满足用户名 2满足邮箱 3都满足
//        return user1;
        List username1 = userMapper.selectList(new QueryWrapper<User>().eq("username", username).or().eq("email", email));
        System.out.println(username1);
        Map<String, Object> map = new HashMap<>();
        map.put("success", 0);
        return map;
    }

    @Override
    public Map lgn(User user) {
        String email = user.getEmail();
        String password = SaSecureUtil.md5(user.getPassword());

        User isuser = userMapper.selectOne(new QueryWrapper<User>().eq("email", email).eq("password", password));
        //登录失败 返回0
        System.out.println(isuser);
        Map<String, Object> map = new HashMap<>();
        if (isuser == null) {
            map.put("userid", 0);
            return map;
        }
        //登录成功
//            if( StpUtil.hasRole("0");)
        map.put("userid", isuser.getUserid());
        return map;

    }

    //忘记密码 邮箱存在1
    @Override
    public Map forgotpwdSelect(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        boolean isemail = userMapper.exists(wrapper.eq("email", user.getEmail()));
        Map<String, Object> map = new HashMap<>();
        if (isemail == true) {
//           map.put("email",user.getEmail());
//           List<User> users = userMapper.selectByMap(map);
//            users.forEach(System.out::println);
            //邮箱存在返回1
            map.put("exist", 1);
            return map;
        }
        map.put("exist", 0);
        return map;
    }

    //（修改密码）3
    @Override
    public Map forgotpwdUpdate(User user) {
        UpdateWrapper<User> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("email", user.getEmail()).set("password", SaSecureUtil.md5(user.getPassword()));

        int update = userMapper.update(user, UpdateWrapper);
        Map<Object, Object> map = new HashMap<>();
        if (update != 0) {
            map.put("success", 1);
            return map;
        }
        map.put("success", 0);
        return map;
    }


}
