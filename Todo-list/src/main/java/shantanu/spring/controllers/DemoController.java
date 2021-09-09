package shantanu.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import shantanu.spring.service.DemoService;

@Slf4j
@Controller
public class DemoController {

    //== Constants ==
    private final DemoService demoService;

    //== Constructor ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    //== Controllers ==

    //== http://localhost:8080/Todo-list/hello ==
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    //== http://localhost:8080/Todo-list/welcome ==
    @GetMapping("/welcome")
    public String welcome(@RequestParam String user, Model model){
        log.info("in /welcome");
        model.addAttribute("helloMessage",demoService.getHelloMessage(user));
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("Called welcomeMessage()");
        return demoService.getWelcomeMessage();
    }
}
