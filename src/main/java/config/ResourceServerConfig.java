package config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configurable
@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http
               .authorizeHttpRequests(authorize -> authorize
                       .requestMatchers("/api/**").hasAnyAuthority("SCOPE_message:read")
                       .anyRequest().authenticated()
               )
               .oauth2ResourceServer(oauth2 -> oauth2
                       .jwt(jwt -> jwt
                               .jwtAuthenticationConverter(myConverter())));

        return  http.build();
    }
}
