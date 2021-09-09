package shantanu.spring.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    //== Public Methods ==
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to the application";
    }
}
