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
 * @since 2022-03-03 10:36:08
 */
@Getter
@Setter
@TableName("about2")
public class About2 {

    @TableId("homeid2")
    private String homeid2;

    @TableField("title2")
    private String title2;

    @TableField("content2")
    private String content2;

    @TableField("pic2")
    private String pic2;


}
