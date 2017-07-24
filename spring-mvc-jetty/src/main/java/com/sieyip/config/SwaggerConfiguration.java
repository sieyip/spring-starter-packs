package com.sieyip.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.Principal;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/docs", "/swagger-ui.html");
		registry.addRedirectViewController("/docs/", "/swagger-ui.html");
		registry.addRedirectViewController("/docs.json", "/v2/api-docs");
	}

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(new ApiInfoBuilder()
				.title("RIDE - Restaurant Identity Service")
				.build())
			.forCodeGeneration(true)
			.ignoredParameterTypes(Principal.class)
			.useDefaultResponseMessages(false)
			.select()
			.paths(documentedPaths())
			.build();
	}

	private Predicate<String> documentedPaths() {
		return or(
			regex("/api.*"));
	}
}
