package com.clinique.gestion_clinique_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Configuration de la sécurité pour HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Désactive CSRF si nécessaire
                .authorizeRequests()
                .requestMatchers("/login", "/register").permitAll()  // Pages accessibles sans authentification
                .anyRequest().authenticated()  // Toutes les autres pages nécessitent authentification
                .and()
                .formLogin()
                .loginPage("/login")  // Page de login personnalisée
                .permitAll()
                .and()
                .logout()
                .permitAll();  // Autoriser la déconnexion
        return http.build();  // Retourne la configuration sous forme de DefaultSecurityFilterChain
    }

    // Bean pour encoder les mots de passe avec BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Utiliser BCrypt pour hasher les mots de passe
    }
}
