package chaezzic.chaezzicspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http
                // 권한 설정
                .authorizeRequests()
                .antMatchers("/").permitAll() // 로그인 하지 않았을 때 접근할 수 있는 url
                .anyRequest().authenticated() // 나머지는 모두 로그인을 해야 접근 가능

                .and()

                .oauth2Login() // oauth 로그인 기능만 구현. 폼 로그인은 필요 없음 (깃으로 회원가입 해야 함)
                .authorizationEndpoint()
                .baseUri("/login");
        return http.build();
    }
}
