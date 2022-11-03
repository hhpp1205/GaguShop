package kr.ac.kopo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Set;


public class MessageSource {

    @Bean
    public org.springframework.context.MessageSource messageSource(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("message.error");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

}
