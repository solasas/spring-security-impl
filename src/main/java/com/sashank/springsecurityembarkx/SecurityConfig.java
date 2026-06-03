package com.sashank.springsecurityembarkx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(requests ->
                        requests.anyRequest().authenticated()
                );
            //making session stateless i.e. not creating session for each request (cookies disabled)
                http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .formLogin(withDefaults());
//                .httpBasic(withDefaults());

        return http.build();
    }

    //in-memory authentication with two users user1 and admin with their respective roles and passwords
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withUsername("user1").
                password("{noop}password1").
                roles("USER").
                build();

        UserDetails admin= User.withUsername("admin ").
                password("{noop}adminpassword").
                roles("ADMIN").
                build();
        return new InMemoryUserDetailsManager(user1,admin);
    }
}
