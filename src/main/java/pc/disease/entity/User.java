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

    @TableField("userpass")
    private String userpass;

    @TableField("identity")
    private String identity;

    @TableField("symptoms")
    private String symptoms;


}
