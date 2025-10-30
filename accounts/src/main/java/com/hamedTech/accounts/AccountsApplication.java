package com.hamedTech.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Account Microservice REST APIS documentation",
				description = "Bank Accounts microservice REST APIS documentation",
				version = "V1",
				contact = @Contact(
						name = "Hamed miri",
						email = "hamedmiri72@gmail.com",
						url = "hamedmiri72@gmail.com"
				),
				license = @License(
						name = "Hamed miri",
						url = "hamedmiri72@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Account Microservices REST APIS documentation",
				url = "hamedmiri72@gmail.com"

		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
