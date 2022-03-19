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
 * @since 2022-03-19 07:40:10
 */
@Getter
@Setter
@TableName("communication")
public class Communication {

    /**
     * 交流id
     */
    @TableId("id")
    private String id;

    /**
     * 用户id
     */
    @TableField("userid")
    private String userid;

    /**
     * 发布内容
     */
    @TableField("publicationcontent")
    private String publicationContent;

    /**
     * 用户状态（0差，1较差，2中等，3较好，4很好）
     */
    @TableField("publicationstate")

    private String publicationState;

    /**
     * 发布时间
     */
    @TableField("time")
    private LocalDateTime time;


}
