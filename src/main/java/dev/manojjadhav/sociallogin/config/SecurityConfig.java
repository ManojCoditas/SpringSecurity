package dev.manojjadhav.sociallogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration  /* annotation is used to indicate that a class declares one or more
                @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.*/
@EnableWebSecurity /*you're indicating to Spring Boot that the class contains configuration related to web security.*/
public class SecurityConfig {


    /*These filters work together to perform various security-related tasks such as authentication, authorization, and protection against common web application vulnerabilities.*/


    /*HttpSecurity configuration method allows you to define rules and settings related to authentication, authorization, and other security aspects*/
    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{

        return http
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/").permitAll();
                    auth.anyRequest().authenticated();
                })
                .oauth2Login(withDefaults())
                .formLogin(withDefaults())
                .build();

    }

}
