package de.springbootbuch.messaging_cloudstream.payment_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ObjectMapper objectMapper(
		final JsonComponentModule jsonComponentModule
	) {
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(jsonComponentModule);
		return objectMapper;
	}
	
	@Bean
	MessageConverter messageConverter(
		final ObjectMapper objectMapper
	) {
		final MappingJackson2MessageConverter converter 
			= new MappingJackson2MessageConverter();
		converter.setObjectMapper(objectMapper);
		
		return converter;
	}
}