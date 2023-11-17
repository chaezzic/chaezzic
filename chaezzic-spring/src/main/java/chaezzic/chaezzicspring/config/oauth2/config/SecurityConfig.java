package chaezzic.chaezzicspring.config.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        
        http    .csrf().disable()

                // 권한 설정
                .authorizeRequests()
                    .antMatchers("/").permitAll() // 로그인 하지 않았을 때 접근할 수 있는 url
                    .antMatchers("/users/new").permitAll()
                    .antMatchers("/users/List").authenticated()
                    .antMatchers("/error").permitAll()
                    .anyRequest().authenticated() // 나머지는 모두 로그인을 해야 접근 가능

                .and()

                //oauth 로그인 설정
                .oauth2Login()
                    //.userInfoEndpoint().userService(customOAuth2UserService) customOAuth2UserService 미구현
                    .authorizationEndpoint()
                        .baseUri("/login") // "/login" 으로 접근 시 oauth 로그인 요청

        ;
        return http.build();
    }
}
