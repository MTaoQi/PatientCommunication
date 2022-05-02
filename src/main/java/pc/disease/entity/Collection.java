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
 * @since 2022-03-27 12:58:11
 */
@Getter
@Setter
@TableName("collection")
public class Collection {

    /**
     * 收藏id
     */
    @TableId("id")
    private String id;

    /**
     * 用户id
     */
    @TableField("userid")
    private String userid;

    /**
     * 交流id
     */
    @TableField("communicationid")
    private String communicationid;

    /**
     * 收藏时间
     */
    @TableField("time")
    private String time;


}
