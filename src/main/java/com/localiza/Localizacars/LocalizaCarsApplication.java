package com.localiza.Localizacars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class LocalizaCarsApplication {

	public static void main(String[] args) {

		SpringApplication.run(LocalizaCarsApplication.class, args);
	}
}
