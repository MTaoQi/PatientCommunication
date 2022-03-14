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
@TableName("carousel")
public class Carousel {

    /**
     * 轮播图id
     */
    @TableId("carouselid")
    private Integer carouselid;

    /**
     * 轮播图名字
     */
    @TableField("name")
    private String name;

    /**
     * 轮播图url
     */
    @TableField("src")
    private String src;


    /**
     * 当前时间
     */
    @TableField("createtime")
    private String createtime;

    /**
     * 是否有效，1有效，0无效
     */
    @TableField("isvalid")
    private Integer isvalid;



}
