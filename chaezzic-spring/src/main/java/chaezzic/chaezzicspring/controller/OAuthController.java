package chaezzic.chaezzicspring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/token")
    public String giveToken(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        String token = (String) httpSession.getAttribute("accessToken");
        return token;
    }
}
