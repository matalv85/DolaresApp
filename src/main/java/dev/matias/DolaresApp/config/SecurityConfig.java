/*package dev.matias.DolaresApp.config;

import dev.matias.DolaresApp.service.JpaUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {

    private final JpaUserDetailService userDetailService;

    public SecurityConfig(JpaUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http
                //.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher
                        .antMatcher("/h2-console/**")
                ))
                .authorizeHttpRequests(auth -> {
                    //auth.requestMatchers("/h2-console/**").permitAll();
                    auth.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll();
                    auth.requestMatchers("/").permitAll();
                    auth.anyRequest().authenticated();
                })
                .userDetailsService(userDetailService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
*/