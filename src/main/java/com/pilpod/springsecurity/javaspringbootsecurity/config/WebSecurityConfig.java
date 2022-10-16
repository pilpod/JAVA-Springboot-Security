package com.pilpod.springsecurity.javaspringbootsecurity.config;

import static org.springframework.security.config.Customizer.*;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // Misma configuration que la por defecto
        // http
        //     .authorizeHttpRequests(authz -> authz.anyRequest().authenticated())
        //     .httpBasic(withDefaults());
        
        http.cors().and()
            .httpBasic(withDefaults())
            .authorizeRequests()
            .antMatchers("/api/v1/helloworld","/api/v1/context-holder","/api/v1/welcome").permitAll()
            .antMatchers("/api/v1/admin").hasRole("ADMIN")
            .anyRequest().authenticated();

        return http.build();
    }

    // Configurar un usuario en memoria
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = encoder.encode("1234");
        System.out.println(password);
        
        UserDetails user = User.withUsername("admin")
                            .password(password)
                            .roles("ADMIN")
                            .build();
        
        return new InMemoryUserDetailsManager(user);
    }
    
}
