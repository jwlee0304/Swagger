package com.api.swagger;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean 
	public Docket api () {
		return new Docket(DocumentationType.SWAGGER_2)
				.consumes(getConsumeContentTypes())
				.produces(getProduceContentTypes())
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				/* .paths(PathSelectors.any()) */ 
				.paths(PathSelectors.ant("/api/**")) 
				.build();
	}
	
	
	private ApiInfo getApiInfo(){
		return new ApiInfoBuilder()
				.title("Test API")
				.description("TEST API EXAMPLE")
				.contact(new Contact("findhouse", "http://www.findhouse.co.kr", "jwlee@mediawill.com"))
				.version("1.0")
				.build();
	}
	
	private Set<String> getConsumeContentTypes() {
		Set<String> consumes = new HashSet<>();
		consumes.add("application/json;charset=UTF-8");
		consumes.add("application/x-www-form-urlencoded");
		return consumes;		
	}
	
	private Set<String> getProduceContentTypes () {
		Set<String> produces = new HashSet<>();
		produces.add("application/json;charset=UTF-8");
		return produces;
	}
}
