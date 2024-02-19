package com.example.vass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.vass"})
@EnableJpaRepositories(basePackages = {"com.example.vass"})
public class VassApplication {

	// Ejemplo: http://localhost:8080/consultprices?marca=ZARA&fecha=2020-06-14-00.00.00&idProducto=35455
	
	public static void main(String[] args) {
		SpringApplication.run(VassApplication.class, args);
	}

}
