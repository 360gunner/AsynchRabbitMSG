package com.gunner.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gunner.demo.messaging.RabbitTestMessagingService;
import com.gunner.demo.model.Test;
import com.gunner.demo.model.TestCRUD;
import com.gunner.demo.model.HTTPTYPE;
import com.gunner.demo.repo.testRepo;

@RestController
public class TestController {
	
	@Autowired
	testRepo tr;
	
	@Autowired
	RabbitTestMessagingService r;
	
	@PostMapping("/testing")
	public @ResponseBody HttpStatus hello_post(@RequestBody Test t) { 
		
		
		try {
			Test result = tr.save(t);
			
			TestCRUD tt = new TestCRUD(t,HTTPTYPE.POST);
			
			r.sendTest(tt);
			
			return HttpStatus.CREATED;
		}
		catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
	
}
