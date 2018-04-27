package com.abdts.auth.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <B>文件名称：</B>SwaggerConfig.java<BR>
 * <B>文件描述：</B><BR>
 * <p>
 * <B>版权声明：</B>(C)2014-2015<BR>
 * <B>公司部门：</B><BR>
 * <B>创建时间：</B>2016年6月30日<BR>
 *
 * @author
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan("com.abdts.auth")
public class SwaggerUtils {


    @Bean
    public Docket studentApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                description("青鸟杯项目登录模块").
                title("登录测试").
                version("V1.0").build();
    }

}  