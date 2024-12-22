package com.renodesor.taam.taambff;

import com.renodesor.taam.taambff.client.TaamApiClient;
import com.renodesor.taam.taambff.service.TaamProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.renodesor.taam.taambff.client")
public class TaamBffApplication implements CommandLineRunner {

	@Autowired
	private TaamApiClient taamApiClient;
	public static void main(String[] args) {
		SpringApplication.run(TaamBffApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			TaamProcessor taamProcessor = new TaamProcessor(taamApiClient);
			taamProcessor.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
