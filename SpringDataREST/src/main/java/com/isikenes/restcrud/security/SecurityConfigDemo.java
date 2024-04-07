package com.isikenes.restcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfigDemo {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/api/students").hasRole("student")
                        .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("student")
                        .requestMatchers(HttpMethod.POST, "/api/students").hasRole("president")
                        .requestMatchers(HttpMethod.PUT, "/api/students/**").hasRole("president")
                        .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("admin")
        ));
        http.httpBasic(Customizer.withDefaults());

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }


/*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails enes= User.builder()
                .username("enes")
                .password("{noop}test123")
                .roles("admin","student","president")
                .build();

        UserDetails ali= User.builder()
                .username("ali")
                .password("{noop}test123")
                .roles("president","student")
                .build();

        UserDetails mehmet= User.builder()
                .username("mehmet")
                .password("{noop}test123")
                .roles("student")
                .build();

        return new InMemoryUserDetailsManager(enes, ali, mehmet);
    }

 */

}
