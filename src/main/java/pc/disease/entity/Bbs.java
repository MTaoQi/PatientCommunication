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
 * @since 2022-04-10 09:40:02
 */
@Getter
@Setter
@TableName("bbs")
public class Bbs {

    /**
     * id
     */
    @TableId("id")
    private String id;

    /**
     * 用户id
     */
    @TableField("userid")
    private String userid;

    /**
     * 模块名
     */
    @TableField("name")
    private String name;

    /**
     * 简介
     */
    @TableField("brief")
    private String brief;


}
