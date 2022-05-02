package pc.disease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lazymxh
 * @since 2022-04-14 09:45:18
 */
@Getter
@Setter
@TableName("connected")
public class Connected {

    /**
     * id
     */
    @TableId("id")
    private String id;

    /**
     * 用户id
     */
    @TableField("userid")
    private String userid;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 模块名
     */
    @TableField("mname")
    private String mname;

    /**
     * 标题
     */
    @TableField("tit")
    private String tit;

    /**
     * 内容
     */
    @TableField("con")
    private String con;

    /**
     * 点赞数量
     */
    @TableField("nums")
    private Integer nums;

    /**
     * 发布时间
     */
    @TableField("time")
    private String time;


}
