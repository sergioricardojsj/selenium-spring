package com.home.teste;

import com.home.teste.configuration.Settings;
import com.home.teste.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
@SpringBootTest
public class TesteApplicationTests {

	@Autowired
	private Settings settings;

	public static void main(String[] args) {
		SpringApplication.run(TesteApplicationTests.class);
	}

	@Test
	void contextLoads() {
		new LoginPage().efetuarLogin();
	}

}
