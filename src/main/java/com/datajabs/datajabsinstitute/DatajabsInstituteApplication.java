package com.datajabs.datajabsinstitute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableJpaRepositories("com.datajabs.datajabsinstitute.repository")
@EntityScan("com.datajabs.datajabsinstitute.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class DatajabsInstituteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatajabsInstituteApplication.class, args);
	}

}
