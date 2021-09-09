package shantanu.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import shantanu.spring.util.ViewNames;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "shantanu.spring")
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    //== Constants ==
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX = ".jsp";

    @Bean
    public ViewResolver viewResolver(){
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }

//    @Bean
//    public DemoService demoService(){
//        return new DemoServiceImpl();
//    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        log.info("Added Home Page");
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }
}
