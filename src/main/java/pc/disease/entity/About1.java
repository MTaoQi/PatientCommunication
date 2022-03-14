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
 * @since 2022-03-03 10:36:07
 */
@Getter
@Setter
@TableName("about1")
public class About1 {

    /**
     * 标识id
     */
    @TableId("homeid1")
    private String homeid1;

    /**
     * 题目
     */
    @TableField("title1")
    private String title1;

    /**
     * 内容
     */
    @TableField("content1")
    private String content1;

    /**
     * 图片url
     */
    @TableField("pic1")
    private String pic1;


}
