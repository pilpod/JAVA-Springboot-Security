package com.pilpod.springsecurity.javaspringbootsecurity.config;

import static org.springframework.security.config.Customizer.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // Misma configuration que la por defecto
        // http
        //     .authorizeHttpRequests(authz -> authz.anyRequest().authenticated())
        //     .httpBasic(withDefaults());
        
        http
            // by default uses a Bean by the name of corsConfigurationSource
            // https://docs.spring.io/spring-security/reference/servlet/integrations/cors.html
            .cors(withDefaults())
            .httpBasic(withDefaults())
            .formLogin().disable()
            .authorizeRequests()
            .antMatchers("/api/v1/**").permitAll()
            .antMatchers("/api/v1/admin","api/v1/login").hasRole("ADMIN")
            .anyRequest().authenticated();

        return http.build();
    }

    // Configuración global de CORS utilizando spring segurity con Basic Authentication
    /* @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
    } */

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
