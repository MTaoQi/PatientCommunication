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
 * @since 2022-03-27 12:58:12
 */
@Getter
@Setter
@TableName("comments")
public class Comments {

    /**
     * 回复id
     */
    @TableId("replyid")
    private String replyid;

    /**
     * 交流id
     */
    @TableField("communicationid")
    private String communicationid;

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
     * 回复内容
     */
    @TableField("replycom")
    private String replycom;

    /**
     * 回复时间
     */
    @TableField("time")
    private String time;


}
