package mx.edu.utez.sda.d8cspringmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)

public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user1= User.withUsername("user1")
                .password(
                        passwordEncoder().encode("12345")
                )
                .roles("USER")
                .build();
        UserDetails admin= User.withUsername("admin")
                .password(
                        passwordEncoder().encode("admin123")
                )
                .roles("ADMIN")
                .build();
        UserDetails recep= User.withUsername("recepcion")
                .password(
                        passwordEncoder().encode("rece123")
                )
                .roles("RECE")
                .build();
        UserDetails adulto= User.withUsername("adulto")
                .password(
                        passwordEncoder().encode("qwerty")
                )
                .roles("ADULT")
                .build();
        UserDetails child= User.withUsername("child")
                .password(
                        passwordEncoder().encode("qwerty")
                )
                .roles("CHILD")
                .build();
        return new InMemoryUserDetailsManager(user1,admin,recep,adulto,child);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests((request)->{
            request.requestMatchers("/","/index").permitAll();
            request.anyRequest().authenticated();
        });
        httpSecurity.formLogin((login)->{
            login.loginPage("/login").permitAll();
        });

        httpSecurity.logout((logout)->{
            logout.permitAll();
        });

        return httpSecurity.build();
    }
}
