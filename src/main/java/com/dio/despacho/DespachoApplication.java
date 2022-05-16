package com.dio.despacho;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DespachoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DespachoApplication.class, args);
	}

}
