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
@TableName("treatdetail")
public class Treatdetail {

    /**
     * 种类报告id
     */
    @TableId("reportid")
    private String reportid;

    /**
     * 种类名字
     */
    @TableField("typ")
    private String typ;

    /**
     * 描述
     */
    @TableField("des")
    private String des;

    /**
     * 用途
     */
    @TableField("effect")
    private String effect;

    /**
     * 副作用
     */
    @TableField("side")
    private String side;


}
