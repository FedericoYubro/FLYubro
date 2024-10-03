package com.flyubro.aircraft_leasing_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class BasicConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder){
        UserDetails user = User.withUsername("flyubro")
                .password(passwordEncoder().encode("fly123")).build();
        return new InMemoryUserDetailsManager(user);
    }

    /*
     * permitAll no requiere permisos de logeo
     * authenticated requiere permisos de logeo
     * anonymous
     * */
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(request->request.requestMatchers(new AntPathRequestMatcher("/list")).permitAll())
                .authorizeHttpRequests(request->request.requestMatchers(new AntPathRequestMatcher("/find")).authenticated())
                .authorizeHttpRequests(request->request.requestMatchers(new AntPathRequestMatcher("/")).anonymous())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}