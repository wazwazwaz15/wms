package com.wms.inboundservice;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Tag(name = "Inbound", description = "入庫模組")
public class InboundServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InboundServiceApplication.class, args);
	}

}
