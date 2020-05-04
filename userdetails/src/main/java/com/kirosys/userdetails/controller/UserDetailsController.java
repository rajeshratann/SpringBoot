package com.kirosys.userdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirosys.userdetails.exception.RecordNotFoundException;
import com.kirosys.userdetails.model.UserDetails;
import com.kirosys.userdetails.service.UserDetailsService;

@RestController
@RequestMapping("/userdetails")
public class UserDetailsController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping
	public ResponseEntity<List<UserDetails>> getAllUserDetails(){
		
		List<UserDetails> allUserDetailsList = userDetailsService.getAllUserDetails();
		
		return new ResponseEntity<>(allUserDetailsList, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable("id") Long id) throws RecordNotFoundException{
		
		UserDetails userDetails = userDetailsService.getUserDetailsById(id);
		
		return new ResponseEntity<>(userDetails, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<UserDetails> createOrUpdateUserDetails(UserDetails userDetails) throws RecordNotFoundException{
		
		UserDetails updateUserDatails = userDetailsService.createOrUpdateUserDetails(userDetails);
		
		return new ResponseEntity<>(updateUserDatails, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteUserDetailsById(@PathVariable("id") Long id) throws RecordNotFoundException {
		userDetailsService.deleteUserDetailsById(id);
		return HttpStatus.FORBIDDEN;
		
	}

}
