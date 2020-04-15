package com.gunner.demo.messaging;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunner.demo.model.TestCRUD;

@Service
public class RabbitTestMessagingService
       implements TestService {
  
  private RabbitTemplate rabbit;
  
  @Autowired
  public RabbitTestMessagingService(RabbitTemplate rabbit) {
    this.rabbit = rabbit;
  }
  
  public void sendTest(TestCRUD test) {
	try {  
	new Queue("test.queue");}
	catch(Exception e) {}
    rabbit.convertAndSend("test.queue", test);
  }
  
}