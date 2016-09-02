package me.daxnet.calculationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = {
	    CalculationController.class
	})
public class App
{
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
    }
    
    @Bean
    public Docket calculationApi() {
    	return new Docket(DocumentationType.SWAGGER_2)
    			//.groupName("calculation")
    			.select()
    			.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
    			.paths(PathSelectors.any())
    			.build()
    			.apiInfo(apiInfo());
    }
    
    @Bean
    public UiConfiguration uiConfig() {
    	return new UiConfiguration(
    	        "validatorUrl",// url
    	        "none",       // docExpansion          => none | list
    	        "alpha",      // apiSorter             => alpha
    	        "schema",     // defaultModelRendering => schema
    	        UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
    	        false,        // enableJsonEditor      => true | false
    	        true);        // showRequestHeaders    => true | false
    }
    
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
    			.title("Daxnet Calculation Service")
    			.description("Spring RESTful Sample with Swagger")
    			.termsOfServiceUrl("https://github.com/daxnet/calculation-service")
    			.license("Apache License Version 2.0")
    			.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
    			.version("1.0")
    			.build();
    }
}
