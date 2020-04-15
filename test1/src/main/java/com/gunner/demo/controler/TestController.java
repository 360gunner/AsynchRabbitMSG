package com.gunner.demo.controler;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path="/test",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_get() { 
		
		
		try {
			List<Test> result = tr.findAll();
			
			return new ResponseEntity<List<Test>>( result, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<Test>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/test/{id}",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_get_id(@PathVariable int id) { 
		
		
		try {
			Test result = tr.findById(id).get();
			
			return new ResponseEntity<Test>( result, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Test>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/test",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_post(@RequestBody Test t) { 
		
		
		try {
			Test result = tr.save(t);
			
			TestCRUD tt = new TestCRUD(t,HTTPTYPE.POST);
			
			r.sendTest(tt);
			
			return new ResponseEntity<Test>( result, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Test>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping(path="/test",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_put(@RequestBody Test t) { 
		
		
		try {
			Test result = tr.save(t);
			
			TestCRUD tt = new TestCRUD(t,HTTPTYPE.PUT);
			
			r.sendTest(tt);
			
			return new ResponseEntity<Test>( result, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Test>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping(path="/test",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_delete(@RequestBody Test t) { 
		
		
		try {
			tr.delete(t);
			
			TestCRUD tt = new TestCRUD(t,HTTPTYPE.DELETE);
			
			r.sendTest(tt);
			
			return new ResponseEntity<Test>( t, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Test>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path="/test/{id}",produces="application/json")
	public @ResponseBody ResponseEntity<?> hello_delete_id(@PathVariable int id) { 
		
		
		try {
			tr.deleteById(id);
			
			TestCRUD tt = new TestCRUD(new Test(id,""),HTTPTYPE.DELETEBYID);
			
			r.sendTest(tt);
			
			return new ResponseEntity<Test>( HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Test>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
