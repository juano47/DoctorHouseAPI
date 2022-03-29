package com.delaiglesia.doctorhouseapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Import(BeanValidatorPluginsConfiguration.class)
@Configuration
@EnableSwagger2
//http://localhost:8122/strategiesBehavior/swagger-ui.html
//https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
public class Swagger2Config {

	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.delaiglesia.doctorhouseapi.controller"))
	      .paths(PathSelectors.regex("/.*"))      
	      .build()
	      //.securityContexts(Lists.newArrayList(securityContext()))
          //.securitySchemes(Lists.newArrayList(apiKey()))
	      .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Doctor House API V2",
	      "API REST con programacion reactiva",
	      "2.0",
	      "Terms of service", 
	      new Contact("DoctorHouse", "www.doctorhouse.com", "contacto@doctorhouse.com"),
	      "License of API", "API license URL", Collections.emptyList());
	}

	//necesario si se usa JWT Token
	/*private ApiKey apiKey() {
		return new ApiKey("Ingresar token", "Bearer ", "header");
	}*/

	/*private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}*/

	/*List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
	}*/

}
