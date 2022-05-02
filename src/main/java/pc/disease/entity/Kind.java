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
 * @since 2022-04-02 01:54:58
 */
@Getter
@Setter
@TableName("kind")
public class Kind {

    /**
     * 类型id
     */
    @TableId("kindid")
    private String kindid;

    /**
     * 主类
     */
    @TableField("maxkind")
    private String maxkind;

    /**
     * 次1
     */
    @TableField("minkind1")
    private String minkind1;

    /**
     * 次2
     */
    @TableField("minkind2")
    private String minkind2;

    /**
     * 次3
     */
    @TableField("minkind3")
    private String minkind3;

    /**
     * 次4
     */
    @TableField("minkind4")
    private String minkind4;

    /**
     * 次5
     */
    @TableField("minkind5")
    private String minkind5;

    /**
     * 次6
     */
    @TableField("minkind6")
    private String minkind6;


}
