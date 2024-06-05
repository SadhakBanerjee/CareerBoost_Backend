//package com.careerboost.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.careerboost.security.JWTAuthenticationFilter;
//import com.careerboost.security.JwtAuthenticationEntryPoint;
//
//@Configuration
//public class SecurityConfig {
//
//
//    @Autowired
//    private JwtAuthenticationEntryPoint point;
//    
//    @Autowired
//    private JWTAuthenticationFilter filter;
//    
//    @Autowired
//    private UserDetailsService userDetailsService;
//    
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    	
//    	 http.csrf(csrf -> csrf.disable())
//         .cors(cors -> cors.disable())
//         .authorizeHttpRequests(auth -> auth
//             .requestMatchers("/CareerBoost/login").permitAll()
//             .requestMatchers("/CareerBoost/register").permitAll()
//             .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
//             .anyRequest().authenticated())
//         .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//     http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//     return http.build();
//    }
//    
//    @Bean
//    public DaoAuthenticationProvider doDaoAuthenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//        return daoAuthenticationProvider;
//    }
//}

package com.careerboost.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.careerboost.security.JWTAuthenticationFilter;
import com.careerboost.security.JwtAuthenticationEntryPoint;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint point;

    @Autowired
    private JWTAuthenticationFilter filter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/CareerBoost/login").permitAll()
                .requestMatchers("/CareerBoost/register").permitAll()
                .requestMatchers( "/swagger-ui/**", "/swagger-ui.html","/swagger-resources/*",
                        "/v3/api-docs/**", "/webjars/**").permitAll()
                .anyRequest().authenticated())
            .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider doDaoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }
}
