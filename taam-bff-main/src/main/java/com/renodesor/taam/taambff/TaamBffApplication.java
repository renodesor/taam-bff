package com.renodesor.taam.taambff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.renodesor.taam.taambff.client")
public class TaamBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaamBffApplication.class, args);
	}

}
