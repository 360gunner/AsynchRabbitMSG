package com.gunner.demo.messaging;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.gunner.demo.model.TestCRUD;




@Component("templateTestReceiver")
public class RabbitTestReceiver implements TestReceiver {

  private RabbitTemplate rabbit;

  public RabbitTestReceiver(RabbitTemplate rabbit) {
    this.rabbit = rabbit;
  }
  
  public TestCRUD receiveTest() {
    return (TestCRUD) rabbit.receiveAndConvert("test.queue");
  }
  
}