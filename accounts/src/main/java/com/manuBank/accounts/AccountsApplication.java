package com.manuBank.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImp")
@OpenAPIDefinition(info = @Info(
		title="Accounts microservices of Manu bank application",
		description = "This application has all the CRUD operations on opening a new account, " +
				"Retrieving all the details about the bank, updating the customer information and deleting the account  and customer information",
		version= "v1",
		contact = @Contact(
				name = "yrlmanoharReddy",
				email="yrlamanoharreddymeda01@gmail.com",
				url="a2hsolutions.com"
		),
		license = @License(
				name= "java_official_license",
				url="javadocs_url"
		)),
		servers = {
				@Server(url="https://localhost:8080/api", description="Local development environment"),
				@Server(url="http://manuBank.com", description="Production environment, not started yet")
		}

)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}
}
