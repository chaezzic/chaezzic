package chaezzic.chaezzicspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    @GetMapping("/secured")
    public String secured(){
        return "It's secured.";
    }

}
