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
@TableName("treat")
public class Treat {

    /**
     * 治疗id
     */
    @TableId("treatid")
    private String treatid;

    /**
     * 治疗名字
     */
    @TableField("name")
    private String name;

    /**
     * 治疗种类
     */
    @TableField("type")
    private String type;


}
