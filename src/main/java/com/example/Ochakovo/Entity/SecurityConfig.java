package com.example.Ochakovo.Entity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 🔑 Защищаем только админку, остальное оставляем открытым
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").authenticated() // Сюда пускаем только с паролем
                        .requestMatchers("/**", "/api/**", "/games/**", "/css/**", "/js/**", "/images/**").permitAll() // Всё остальное — открыто
                )
                // 🔑 Включаем стандартную форму логина
                .formLogin(form -> form
                        .defaultSuccessUrl("/admin/feedback", true) // Куда перенаправить после входа
                        .permitAll()
                )
                // 🔑 Отключаем CSRF для API (чтобы игра могла отправлять отзывы)
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**")
                );

        return http.build();
    }
}