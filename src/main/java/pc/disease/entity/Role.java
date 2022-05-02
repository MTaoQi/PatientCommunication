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
 * @since 2022-04-03 10:44:16
 */
@Getter
@Setter
@TableName("role")
public class Role {

    /**
     * 角色id
     */
    @TableId("roleid")
    private Integer roleid;

    /**
     * 角色名
     */
    @TableField("rname")
    private String rname;


}
