package pc.utils;

import cn.dev33.satoken.jwt.StpLogicJwtForStyle;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lazymxh
 * @ProjectName: PatientCommunication
 * @Package: IntelliJ IDEA
 * @Description:注入jwt Style 模式
 * @Since: 2022-03-20 13:49
 **/
@Configuration
public class SaTokenConfigure {
    // Sa-Token 整合 jwt (Style模式)
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForStyle();
    }
}
