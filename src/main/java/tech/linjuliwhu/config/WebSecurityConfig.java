package tech.linjuliwhu.config;


import tech.linjuliwhu.auth.TokenAuthenticationProvider;
import tech.linjuliwhu.auth.filter.CorsFilter;
import tech.linjuliwhu.auth.filter.TokenAuthenticationFilter;
import tech.linjuliwhu.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private TokenService tokenService;

    @Configuration
    @Order(1)
    class PredictorSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(new TokenAuthenticationProvider(tokenService));
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .addFilterBefore(new CorsFilter(), UsernamePasswordAuthenticationFilter.class)
                    .addFilterAfter(new TokenAuthenticationFilter(), BasicAuthenticationFilter.class)
//                    .addFilterAfter(new BodyReaderFilter(),BasicAuthenticationFilter.class)
//                    .addFilterAfter(new ResultExceptionTranslationFilter(), ExceptionTranslationFilter.class)
                    .authorizeRequests()

//                    暂时关闭权限认证
//                    .antMatchers("/**").permitAll()

                    // 开启权限拦截
                    .antMatchers("/user/login", "/user/loginWithCode", "/resources/**").permitAll()
                    .antMatchers("/user/getParamValueByName").permitAll()  // 2021.04.18 测试数据库连接
                    .antMatchers("/admin/**", "/admin/**/**", "/user/**", "/user/**/**").hasRole("ADMIN")
                    .antMatchers("/user/**", "/user/**/**").hasRole("USER")
                    .antMatchers("/visitor/**/**", "/visitor/**").permitAll()
                    .and()
                    .csrf()
                    .disable()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
    }
}
