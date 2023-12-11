package chaezzic.chaezzicspring.config.oauth2.service;

import chaezzic.chaezzicspring.domain.User;
import chaezzic.chaezzicspring.repository.UserRepository;
import chaezzic.chaezzicspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
        import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
        import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
        import org.springframework.security.oauth2.core.user.OAuth2User;
        import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {
    @Autowired public UserService userService;
    @Autowired private UserRepository userRepository;
    private final HttpSession httpSession;

    //    깃허브로 부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
//        //System.out.println("userRequest: "+userRequest);
//        //System.out.println("clientRegistration: "+userRequest.getClientRegistration());  //client에 대한 정보들이 받아짐
//        System.out.println("AccessToken: "+userRequest.getAccessToken().getTokenValue());
//        //System.out.println("getAttributes: "+super.loadUser(userRequest).getAttributes()); //유저 정보를 받아옴

        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("******** User Request ********");
        log.info("AccessToken: "+userRequest.getAccessToken().getTokenValue());
        log.info("repo url: " + oAuth2User.getAttribute("repos_url"));
        log.info("email: " + oAuth2User.getAttribute("email"));
        log.info("userId: " + (long) (int) oAuth2User.getAttribute("id"));
        log.info("******************************");

        Long userId = (long) (int) oAuth2User.getAttribute("id");
        String name = oAuth2User.getAttribute("login");
        String email = oAuth2User.getAttribute("email");
        String repoUrl = oAuth2User.getAttribute("repos_url");

        Optional<User> findUser = userRepository.findById(userId);
        if (findUser.isEmpty()){
            User user = new User();
            user.setId(userId);
            user.setName(name);
            user.setEmail(email);
            user.setRepoUrl(repoUrl);

            httpSession.setAttribute("user", user);
            httpSession.setAttribute("accessToken", userRequest.getAccessToken().getTokenValue());

            userRepository.save(user);
        }

        return oAuth2User;
    }
}
