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
 * @since 2022-04-15 10:58:01
 */
@Getter
@Setter
@TableName("report")
public class Report {

    /**
     * id
     */
    @MppMultiId // 复合主键
    @TableField("userid")
    private String userid;

    /**
     * 模块交流id
     */
    @MppMultiId // 复合主键
    @TableField("conid")
    private String conid;

    /**
     * 举报者邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 举报理由
     */
    @TableField("text")
    private String text;

    /**
     * 举报时间
     */
    @TableField("time")
    private String time;


}
