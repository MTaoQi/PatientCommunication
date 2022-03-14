package pc.disease.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pc.disease.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lazymxh
 * @since 2022-01-18 04:10:52
 */
/**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
  //  @Select("select * from user")
//List<String> selAllUser();
List<String> selAllUser();

}
