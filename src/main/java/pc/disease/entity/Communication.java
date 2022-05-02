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
 * @since 2022-03-23 02:55:25
 */
@Getter
@Setter
@TableName("communication")
public class Communication {

    /**
     * 标识符
     */
    @TableId("id")
    private String id;

    /**
     * 用户id
     */
    @TableField("userid")
    private String userid;

    @TableField("username")
    private String username;

    /**
     * 交流主题
     */
    @TableField("titlepc")
    private String titlepc;

    /**
     * 交流内容
     */
    @TableField("contentpc")
    private String contentpc;

    /**
     * 点赞数量
     */
    @TableField("numlike")
    private Integer numlike;

    /**
     * 收藏数量
     */
    @TableField("numcollection")
    private Integer numcollection;


    /**
     * 发布时间
     */
    @TableField("time")
    private String time;


}
