package com.edu.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {
	
	/*
	addMapping() : 설정된 경로에 대해 CORS를 허용한다. 만약 특정 경로만 허용하고
		싶다면 "/apis/*" 와 같이 작성하면된다.
	allowedOriginPatterns() : 특정 오리진에 대해 허용한다. 만약 특정 오리진만
		허용하고 싶다면 "http://sample.com"과 같이 작성하면된다.
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOriginPatterns("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedHeaders("Authorization", "Content-Type")
			.exposedHeaders("Custom-Header")
			.allowCredentials(true)
			.maxAge(3600);
	}
	
	
}
