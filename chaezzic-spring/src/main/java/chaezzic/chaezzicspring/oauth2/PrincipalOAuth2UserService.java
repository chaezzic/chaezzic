package chaezzic.chaezzicspring.oauth2;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
        import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
        import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
        import org.springframework.security.oauth2.core.user.OAuth2User;
        import org.springframework.stereotype.Service;

@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {
    //    깃허브로 부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        System.out.println("******** User Request ********");
        System.out.println("userRequest: "+userRequest);
        System.out.println("clientRegistration: "+userRequest.getClientRegistration());  //client에 대한 정보들이 받아짐
        System.out.println("AccessToken: "+userRequest.getAccessToken().getTokenValue());
        System.out.println("getAttributes: "+super.loadUser(userRequest).getAttributes()); //유저 정보를 받아옴
        System.out.println("******************************");

        return super.loadUser(userRequest);
    }
}
