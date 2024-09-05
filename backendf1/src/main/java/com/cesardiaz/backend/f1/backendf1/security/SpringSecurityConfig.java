package com.cesardiaz.backend.f1.backendf1.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.cesardiaz.backend.f1.backendf1.security.filter.JWTAuthenticationFilter;
import com.cesardiaz.backend.f1.backendf1.security.filter.JWTValidationFilter;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

   @Autowired
   private AuthenticationConfiguration authenticationConfiguration;

   @Bean
   AuthenticationManager authenticationManager() throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
   }

   @Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return http.authorizeHttpRequests((authz) -> authz
            .requestMatchers(HttpMethod.POST, "/api/user").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/teams", "/api/team/{id}").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/user/{id}").hasAnyRole("ADMIN", "SUPERUSER", "USER")
            .requestMatchers(HttpMethod.GET, "/api/driver/{id}", "/api/drivers")
            .hasAnyAuthority("ADMIN", "SUPERUSER", "CREATE_DRIVER")
            .requestMatchers(HttpMethod.POST, "/api/driver", "/api/team", "/api/contractdriver/{id}")
            .hasAnyRole("ADMIN", "SUPERUSER")
            .requestMatchers(HttpMethod.PUT, "/api/contractdriver/{id}").hasAnyRole("ADMIN", "SUPERUSER")
            .anyRequest().authenticated())

            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTValidationFilter(authenticationManager()))
            .csrf(config -> config.disable())
            .cors(cors->cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
   }

   @Bean
   CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowedOriginPatterns(Arrays.asList("*"));
      config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
      config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
      config.setAllowCredentials(true);

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", config);
      return source;
   }

   @Bean
   FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
      FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<>(
            new CorsFilter(corsConfigurationSource()));
      corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
      return corsBean;
   }

}
