package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MarketingConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();

	@RabbitListener(queues = "q.hr.marketing")
	public void listen(String message)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		Employee e = objectMapper.readValue(message, Employee.class);
		System.out.println("On marketing : " + e);
	}

}
