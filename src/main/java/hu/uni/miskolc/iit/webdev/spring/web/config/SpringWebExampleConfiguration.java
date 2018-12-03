package hu.uni.miskolc.iit.webdev.spring.web.config;

import hu.uni.miskolc.iit.webdev.spring.web.controller.QuotesController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Istvan Berzi on 2018.12.02
 */

@Configuration
public class SpringWebExampleConfiguration {

    @Bean
    public QuotesController quotesController(){
        return new QuotesController();
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver result = new InternalResourceViewResolver();
        result.setViewClass(JstlView.class);
        result.setPrefix("/WEB-INF/views");
        result.setSuffix(".html");
        return result;
    }
}
