package com.prospecta.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.models.ComponentAPI;
import com.prospecta.models.Data;
import com.prospecta.models.PayLoads;
import com.prospecta.services.DataService;


@RestController
public class DataController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DataService es;
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<PayLoads>> getData(@PathVariable String category){
		
     
	    Data data= restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
	
     	List<ComponentAPI> lists=  data.getValues();
	  
	    List<PayLoads> payLoad=new ArrayList<>();
	  
	  for(ComponentAPI c:lists) {
		  if(c.getCategory().equals(category)) {
			  payLoad.add(new PayLoads(c.getApi(),c.getDescription()));
		  }
	  }
	  
	  return new ResponseEntity<>(payLoad,HttpStatus.ACCEPTED);
	    
	}
	
	@PostMapping("entries/post")
	public ResponseEntity<List<ComponentAPI>> postData(){
		Data data=restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		List<ComponentAPI> e=es.postData(data);
		
		return new ResponseEntity<>(e,HttpStatus.ACCEPTED);
		
		
	}
	
	

}
