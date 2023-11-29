package chaezzic.chaezzicspring.config.oauth2.config;

import chaezzic.chaezzicspring.config.oauth2.service.PrincipalOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private PrincipalOAuth2UserService principalOAuth2UserService;

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        
        http
                .formLogin().disable()
                .csrf().disable()

                // 권한 설정
                .authorizeRequests()
                    .antMatchers("/").permitAll() // 로그인 하지 않았을 때 접근할 수 있는 url
                    .antMatchers("/users/new").permitAll()
                    .antMatchers("/users/List").authenticated()
                    .antMatchers("/error").permitAll()
                    .anyRequest().authenticated() // 나머지는 모두 로그인을 해야 접근 가능

                .and()

                    .logout()
                        .logoutSuccessUrl("/")

                .and()

                //oauth 로그인 설정
                .oauth2Login()
                    .authorizationEndpoint()
                        .baseUri("/login") // "/login" 으로 접근 시 oauth 로그인 요청

                .and()

                    .userInfoEndpoint()
                    .userService(principalOAuth2UserService) //customOAuth2UserService 미구현
        ;
        return http.build();
    }
}
