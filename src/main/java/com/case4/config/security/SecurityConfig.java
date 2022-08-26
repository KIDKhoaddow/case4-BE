package com.case4.config.security;

import com.case4.config.CustomSuccessHandler;
import com.case4.service.user.IUserService;
import com.case4.config.CustomAccessDeniedHandler;
import com.case4.config.JwtAuthenticationFilter;
import com.case4.config.RestAuthenticationEntryPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUserService userService;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //bean mã hóa pass
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //lấy user từ DB
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");
        http.httpBasic().authenticationEntryPoint(restServicesEntryPoint());//Tùy chỉnh lại thông báo 401 thông qua class restEntryPoint
        http.authorizeRequests()
                .antMatchers("/login","/admin").permitAll()
                .antMatchers(
                        "/image/**",
                        "/changePassword/**",
                        "/username/**",
                        "/userInfo/**",
                        "/**",
                        "/register").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                .antMatchers("/admin").access( "hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()
//                .and().formLogin().loginPage("http://localhost:63342/case4-FE/login.html")
//                .successHandler(new CustomSuccessHandler())
//                .and().exceptionHandling().accessDeniedPage("/accessDenied")
                .and().csrf().disable()
                ;
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
    }
}
