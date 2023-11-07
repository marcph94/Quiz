package com.example.accessingdatamongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import static org.springframework.security.web.util.matcher.RegexRequestMatcher.regexMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager( admin);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.formLogin(form -> form
                .loginPage("/login")
                .permitAll()
        ).csrf().disable().authorizeHttpRequests((authz) -> authz
                        .requestMatchers(antMatcher("/")).permitAll()
                        .requestMatchers(antMatcher("/quizzes")).permitAll()
                        .requestMatchers(antMatcher("/quizz")).permitAll()
                        .requestMatchers(antMatcher("/result")).permitAll()
                        .requestMatchers(antMatcher("/api/v1/quiz")).permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/results").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/addQuiz/").hasRole("ADMIN")
                        .requestMatchers("/addQuiz").hasRole("ADMIN")
                        .anyRequest().authenticated()
                );
        return http.build();
    }

}