package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.User;
import pc.disease.mapper.UserMapper;
import pc.disease.service.StpInterface;

import java.util.List;
import java.util.Map;

/**
 * @Author: lazymxh
 * @ProjectName: PatientCommunication
 * @Package: IntelliJ IDEA
 * @Description:返回一个账号所拥有的角色标识集合
 * @Since: 2022-03-13 19:05
 **/
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    UserMapper userMapper;

    public List<String> getPermissionList(Object loginId, String loginType) {
       return  userMapper.selAllUser();

    }
}
