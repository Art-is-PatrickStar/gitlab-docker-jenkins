package online.hengtian.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能
 *
 * @author czzhao2
 * @created 2019年02月15日 09:35:48
 * @lastModified
 * @history
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @RequestMapping("/success")
    public String success(){
        return "git hook test";
    }

    @GetMapping("/wswTest")
    public String wswTest(){
        return "Wsw Test Success!";
    }

    @RequestMapping("/fuck")
    public String fuckfuck(){
        return "fuck always";
    }
    @RequestMapping("/fucktwo")
    public String fuckfuckfuck(){
        return "fuck twice";
    }

    @GetMapping("/fuckThree")
    public String fuckfuckfuckfuck(){
        return "fuck Three";
    }
}


