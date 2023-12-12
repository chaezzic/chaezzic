package chaezzic.chaezzicspring.controller;

import chaezzic.chaezzicspring.config.oauth2.service.PrincipalOAuth2UserService;
import chaezzic.chaezzicspring.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor
public class OAuthController {
    private final PrincipalOAuth2UserService principalOAuth2UserService;

    @GetMapping("/token")
    public ResponseEntity<?> giveToken(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        String token = (String) httpSession.getAttribute("accessToken");
        System.out.println(token);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/userId")
    public ResponseEntity<?> giveUser(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        Long id = (long) (int) httpSession.getAttribute("userId");
        return ResponseEntity.ok(id);
    }
}
