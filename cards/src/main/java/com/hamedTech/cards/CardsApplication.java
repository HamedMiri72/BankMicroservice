package com.hamedTech.cards;

import com.hamedTech.cards.dto.CardInfoDetailsDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards Microservice",
				description = "Cards Microservice",
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
				description = "HamedTech Documentation",
				url = "https://hamedtech.com"
		)
)
@EnableConfigurationProperties(CardInfoDetailsDto.class)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
