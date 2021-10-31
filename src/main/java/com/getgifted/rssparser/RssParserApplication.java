package com.getgifted.rssparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.getgifted.rssparser"})
public class RssParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RssParserApplication.class, args);
	}

}