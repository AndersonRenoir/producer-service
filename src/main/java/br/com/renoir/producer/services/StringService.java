package br.com.renoir.producer.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.renoir.producer.config.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static br.com.renoir.producer.config.RabbitMQConfig.RK_PRODUCT_LOG;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringService {
	
	private final RabbitTemplate rabbitTemplate;
	
	public void produce(String message) {
		log.info("Received message: " + message);
		rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
	}
}
