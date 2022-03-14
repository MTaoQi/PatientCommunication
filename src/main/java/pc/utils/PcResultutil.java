package pc.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: lazymxh
 * @ProjectName: PatientCommunication
 * @Package: IntelliJ IDEA
 * @Description:统一返回类
 * @Since: 2022-03-14 21:25
 **/

// 统一结果返回类
@Data
@AllArgsConstructor
public class PcResultutil {
    //标识返回的状态码
    private Integer code;
    //标识返回的信息
    private String message;
    //标识返回的数据
    private Object data;

    //私有化，防止new
    private PcResultutil() {  }


}
