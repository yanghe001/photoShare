package core.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptConfig implements WebMvcConfigurer {

    //添加拦截规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercept())
                .addPathPatterns("/**")     //拦截请求
                .excludePathPatterns("/doLogin","/login",
                        "/user/insertUser","/image/find*",
                        "/skill/findAllSkill",
                        "/dynamic/findAllDynamic","/dynamic/insertComment","/dynamic/insertReply","/dynamic/addOrDelPrise",
                        "/**/*.css","/**/*.js", "/**/*.png", "/**/*.jpg",
                        "/**/*.jpeg", "/**/*.gif", "/**/fonts/*");//不拦截登录，和HTML样式

    }
    //全局跨域配置
 /*   @Overrides
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //添加映射路径
                .allowedOrigins("http://192.168.31.160:8080") //放行哪些原始域
                .allowedMethods("*") //放行哪些原始域(请求方式) //"GET","POST", "PUT", "DELETE", "OPTIONS"
                .allowedHeaders("*") //放行哪些原始域(头部信息)
                .allowCredentials(true) //是否发送Cookie信息
                .maxAge(1800);
    }*/
}
