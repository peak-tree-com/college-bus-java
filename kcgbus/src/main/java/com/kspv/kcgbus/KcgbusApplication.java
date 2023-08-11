package com.kspv.kcgbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KcgbusApplication {
		static final Logger logger = LoggerFactory.getLogger("com.kspv.kcgbus");
		public static void main(String[] args) {
			logger.info("Starting Web Server ...");
		SpringApplication.run(KcgbusApplication.class, args);
	}
}
