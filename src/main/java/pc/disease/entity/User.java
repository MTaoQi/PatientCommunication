package pc.disease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lazymxh
 * @since 2022-01-18 04:10:52
 */
@Getter
@Setter
@TableName("user")
public class User {

    @TableId("userid")
    private String userid;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @TableField("identity")
    private int identity;

    @TableField("symptoms")
    private String symptoms;

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", symptoms='" + symptoms + '\'' +
                '}';
    }




}
