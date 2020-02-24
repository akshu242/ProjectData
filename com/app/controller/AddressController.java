package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAddressDao;
import com.app.pojos.AddressDetails;
import com.app.pojos.Agent;
import com.app.pojos.HealthDetails;
import com.app.pojos.PolicyHolder;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private IAddressDao addressDao;
	
//add address details;
	@PutMapping(value="/{custId}",consumes= "application/json",produces = "application/json")
	public ResponseEntity<?> addAddressDetails(@RequestBody AddressDetails address,@PathVariable Integer custId){
		System.out.println("inside add addrsDetails controller");
		System.out.println(address.toString());
		try {
			return new ResponseEntity<AddressDetails>(addressDao.addAddressDetails(custId, address),HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//main
	/*	@PostMapping
	public ResponseEntity<?> addAddressDetails(@RequestBody AddressDetails address){
		System.out.println("inside address add controller");
		try {
			
			return new ResponseEntity<AddressDetails>(addressDao.addAddressDetails(address),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
}
