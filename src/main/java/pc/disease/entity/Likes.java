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
 * @since 2022-03-23 11:47:39
 */
@Getter
@Setter
@TableName("likes")
public class Likes {

    /**
     * 点赞id
     */
    @TableId("id")
    private String id;

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
     * 点赞时间
     */
    @TableField("time")
    private String time;


}
