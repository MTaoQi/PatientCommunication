package pc.disease.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import pc.disease.entity.Role;
import pc.disease.entity.User;
import pc.disease.mapper.RoleMapper;
import pc.disease.mapper.UserMapper;
import pc.disease.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pc.utils.PcResultutil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-03 10:44:16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    //查询用户角色
    public PcResultutil sel(String userid) {
        int roleid = userMapper.selectOne(new QueryWrapper<User>().eq("userid", userid)).getRoleid();
        String rname = roleMapper.selectOne(new QueryWrapper<Role>().eq("roleid", roleid)).getRname();
        return PcResultutil.ok(rname);
    }
}
