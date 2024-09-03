package com.Krishna.demo.Krishna.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
  @Bean
  public UserDetailsService userDetails(PasswordEncoder encrypt) {
    
    UserDetails user = User.withUsername("mani")
                       .password(encrypt.encode("12345678"))
                       .roles("USER")
                       .build();
    UserDetails admin = User.withUsername("ceo")
                 .password(encrypt.encode("12345678"))
                 .roles("ADMIN")
                 .build();
    UserDetails manager = User.withUsername("bhuvana")
                 .password(encrypt.encode("12345678"))
                 .roles("MANAGER")
                 .build();
    UserDetails assManager = User.withUsername("vijay")
                 .password(encrypt.encode("12345678"))
                 .roles("ASSISTMANAGER")
                 .build();
    return new InMemoryUserDetailsManager(user,admin,manager,assManager);
    
  }
  @Bean
  public PasswordEncoder pe() {
    return new BCryptPasswordEncoder();
  }
  @Bean
  public SecurityFilterChain filter(HttpSecurity http) throws Exception {
      return http
          .csrf().disable()
          .authorizeHttpRequests()
          .requestMatchers("/Mani/gym/health/get").permitAll()
          .requestMatchers("/Mani/gym/health/add").authenticated()
          .requestMatchers("/Mani/gym/health/addModel").authenticated()
          .requestMatchers("/Mani/gym/health/delete/{id}").authenticated()
          .requestMatchers("/Mani/gym/health/update/{id}").authenticated()
          .and()
          .httpBasic()
          .and()
          .build();
  }

}
