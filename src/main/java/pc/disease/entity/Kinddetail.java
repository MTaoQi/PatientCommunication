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
 * @since 2022-04-02 01:54:59
 */
@Getter
@Setter
@TableName("kinddetail")
public class Kinddetail {

    /**
     * 类型详情id
     */
    @TableId("idkd")
    private String idkd;

    /**
     * 类型
     */
    @TableField("minkind")
    private String minkind;

    /**
     * 描述
     */
    @TableField("describes")
    private String describes;

    /**
     * 症状
     */
    @TableField("symptom")
    private String symptom;

    /**
     * 治疗
     */
    @TableField("treat")
    private String treat;

    /**
     * 治疗类型
     */
    @TableField("treattype")
    private String treattype;

    @Override
    public String toString() {
        return "Kinddetail{" +
                "idkd='" + idkd + '\'' +
                ", minkind='" + minkind + '\'' +
                ", describes='" + describes + '\'' +
                ", symptom='" + symptom + '\'' +
                ", treat='" + treat + '\'' +
                ", treattype='" + treattype + '\'' +
                '}';
    }
}
