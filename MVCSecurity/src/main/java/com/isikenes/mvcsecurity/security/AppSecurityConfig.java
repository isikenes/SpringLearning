package com.isikenes.mvcsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class AppSecurityConfig {

    //this method tells spring to use jdbc authentication
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure -> configure
                        .requestMatchers("/register","/processRegistration").permitAll()
                        .requestMatchers("/").hasRole("student")
                        .requestMatchers("/list/**").hasRole("president")
                        .requestMatchers("/system/**").hasRole("admin")
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .permitAll())
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(handler -> handler.accessDeniedPage("/access-denied"));

        return http.build();
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails enes = User.builder()
                .username("enes")
                .password("{noop}test123")
                .roles("admin", "student", "president")
                .build();

        UserDetails ali = User.builder()
                .username("ali")
                .password("{noop}test123")
                .roles("president", "student")
                .build();

        UserDetails mehmet = User.builder()
                .username("mehmet")
                .password("{noop}test123")
                .roles("student")
                .build();

        return new InMemoryUserDetailsManager(enes, ali, mehmet);
    }*/
}
