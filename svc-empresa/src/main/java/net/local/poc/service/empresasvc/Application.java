package net.local.poc.service.empresasvc;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import net.local.poc.service.empresasvc.infrastructure.persistence.init.InitDatabase;

@EnableFeignClients
@SpringBootApplication
public class Application implements ApplicationRunner {

	private final InitDatabase dbInitializer;

	public Application(InitDatabase dbInitializer) {
		this.dbInitializer = dbInitializer;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		dbInitializer.init();
	}
}