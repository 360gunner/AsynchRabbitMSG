package com.gunner.demo.messaging;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gunner.demo.model.HTTPTYPE;
import com.gunner.demo.model.Test;
import com.gunner.demo.model.TestCRUD;
import com.gunner.demo.repo.testRepo;


@Component
public class TestListener {
  
  testRepo r;	
	
  @Autowired
  public TestListener(testRepo rt) {
    this.r=rt;
  }

  @RabbitListener(queues = "test.queue")
  public void receiveTest(TestCRUD tt) {
  try{
	  Test test = tt.getTest();
	  if(tt.getType().equals(HTTPTYPE.POST)) {
		  r.save(test);
	  }
  }
  catch(Exception e) {
	  
  }
  }
  
}