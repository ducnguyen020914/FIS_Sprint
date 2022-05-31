package com.poly;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ResourceConfiguration {
   @Bean("messageSource")
   public MessageSource getMessage() {
	   ReloadableResourceBundleMessageSource ms = 
				new ReloadableResourceBundleMessageSource();
		ms.setBasename("classpath:message/category");
		ms.setDefaultEncoding("utf-8");
		return ms;
   }
}
