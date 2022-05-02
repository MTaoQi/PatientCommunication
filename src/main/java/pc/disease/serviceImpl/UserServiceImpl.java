package pc.disease.serviceImpl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Bbs;
import pc.disease.entity.Feel;
import pc.disease.entity.Ubbs;
import pc.disease.entity.User;
import pc.disease.mapper.BbsMapper;
import pc.disease.mapper.FeelMapper;
import pc.disease.mapper.UbbsMapper;
import pc.disease.mapper.UserMapper;
import pc.disease.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;

import java.util.List;


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

    @Autowired
    FeelMapper feelMapper;

    @Autowired
    BbsMapper bbsMapper;

    @Autowired
    UbbsMapper ubbsMapper;

    String[] n = {"肺癌","糖尿病I型","糖尿病II型","癫痫","牛皮癣","眼睛、耳朵、鼻子和喉咙"};
    String[] b = {"对于肺癌患者","患有糖尿病I型的人","患有糖尿病II型的人","对于癫痫患者","对于牛皮癣患者","适用于所有患有影响眼睛，耳朵，鼻子和喉咙的疾病的人"};

    @Override
    public PcResultutil reg(User user) {
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
            uist(user2.getUserid());
            ist(user2.getUserid());

            return PcResultutil.ok();
//            User username1 = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
//            return username1;
        }
        //1满足用户名 2满足邮箱 3都满足
//        return user1;
        List username1 = userMapper.selectList(new QueryWrapper<User>().eq("username", username).or().eq("email", email));
        System.out.println(username1);
        return PcResultutil.error(500,"用户已存在");
    }
    public void uist(String uid){
        Ubbs ubbs = new Ubbs();
        ubbs.setUserid(uid);
        ubbs.setName("2019冠状病毒病");
        ubbs.setBrief("");
        Ubbs ubbs1 = new Ubbs();
        ubbs1.setUserid(uid);
        ubbs1.setName("患者像我");
        ubbs1.setBrief("向所有成员开放，任何条件，整个社区的对话");
        Ubbs ubbs2 = new Ubbs();
        ubbs2.setUserid(uid);
        ubbs2.setName("使用Patient communication的帮助");
        ubbs2.setBrief("有关使用网站和论坛的帮助");
        ubbsMapper.insert(ubbs);
        ubbsMapper.insert(ubbs1);
        ubbsMapper.insert(ubbs2);
    }
    public void ist(String uid){
        for (int i = 0; i < n.length; i++) {
            Bbs bbs = new Bbs();
            bbs.setUserid(uid);
            bbs.setName(n[i]);
            bbs.setBrief(b[i]);
            bbsMapper.insert(bbs);
        }

    }

    @Override
    public PcResultutil lgn(User user) {
        String email = user.getEmail();
        String password = SaSecureUtil.md5(user.getPassword());
        User isuser = userMapper.selectOne(new QueryWrapper<User>().eq("email", email).eq("password", password));
        //登录失败
        System.out.println(isuser);
        if (isuser == null) {
            return PcResultutil.error(500,"用户名或密码错误");
        }
        //登录成功

        else {
   String userid= userMapper.selectOne(new QueryWrapper<User>().eq("email", email).eq("password", password)).getUserid();

            StpUtil.login(email, new SaLoginModel()
                    .setIsLastingCookie(true)
                    .setExtra("userid", userid) );
            String id= String.valueOf(StpUtil.getExtra("userid"));
            boolean userid1 = feelMapper.exists(new QueryWrapper<Feel>().eq("userid", id));
            //登录添加feel表
            if(userid1==false){
                Feel feel = new Feel();
                feel.setUserid(String.valueOf(StpUtil.getExtra("userid")));
                feelMapper.insert(feel);
            }
            List<User> users = userMapper.selectList(new QueryWrapper<User>().eq("email", email).eq("password", password));
            return PcResultutil.ok(users);
        }

    }

    //忘记密码 邮箱存在1
    @Override
    public PcResultutil forgotpwdSelect(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        boolean isemail = userMapper.exists(wrapper.eq("email", user.getEmail()));
        if (isemail == true) {
            return PcResultutil.ok(1,"邮箱存在已确认");
        }
        return PcResultutil.error(500,"邮箱不存在");
    }

    //（修改密码）3
    @Override
    public PcResultutil forgotpwdUpdate(User user) {
        UpdateWrapper<User> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("email", user.getEmail()).set("password", SaSecureUtil.md5(user.getPassword()));
        int update = userMapper.update(user, UpdateWrapper);
        if (update != 0) {
            return PcResultutil.ok(1,"修改成功");
        }
        return PcResultutil.error(500,"修改失败");
    }

    //根据id查用户名
    @Override
    public PcResultutil getUname(String userid) {
        String username = userMapper.selectOne(new QueryWrapper<User>().eq("userid", userid)).getUsername();
        return PcResultutil.ok(username);
    }
    //网站用户总数
    @Override
    public PcResultutil getnum() {
        int count = Math.toIntExact(userMapper.selectCount(new QueryWrapper<User>()));
        return PcResultutil.ok(count);
    }
    //照顾者数量
    @Override
    public PcResultutil care() {
        int count = Math.toIntExact(userMapper.selectCount(new QueryWrapper<User>().eq("identity", 1)));
        return PcResultutil.ok(count);
    }


}
