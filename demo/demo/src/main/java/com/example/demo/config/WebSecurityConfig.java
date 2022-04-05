package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;
import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // http 시큐리티 빌더
        http.cors() // WebMvcConfig에서 이미 설정했으므로 기본 cors 설정
            .and()
            .csrf() // 현재 csrf 사용 X
                .disable()
            .httpBasic()    // token 사용
                .disable()
            .sessionManagement()    // session 기반 x
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()    // '/'와 '/auth/**'(로그인)는 인증 X
                .antMatchers("/", "/auth/**").permitAll()
            .anyRequest()   // 위 경로 외 다른 경로는 모두 인증
                .authenticated();

        // filter 등록, 매 요청마다 CorsFilter(그냥 적당한 필터) 실행 후 jwt..Filter 실행
        http.addFilterAfter(
            jwtAuthenticationFilter,
            CorsFilter.class
        );
    }

}