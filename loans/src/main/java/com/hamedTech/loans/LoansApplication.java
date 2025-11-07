package com.hamedTech.loans;

import com.hamedTech.loans.dto.LoansInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans Microservice REST API Implementation",
				description = "Loans Microservice REST API Implementation for Spring Boot Application",
				version = "V1",
				contact = @Contact(
						name = "Hamed MIRI",
						email = "hamed.miri@hamedtech.com",
						url = "https://hamedtech.com"

				),
				license = @License(
						name = "HamedTech License",
						url = "https://hamedtech.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Loans Microservice REST API Documentation",
				url = "https://hamedtech.com"
		)
)
@EnableConfigurationProperties(LoansInfoDto.class)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
