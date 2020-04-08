package com.kirosys.userdetails.service;

import java.util.List;

import com.kirosys.userdetails.exception.RecordNotFoundException;
import com.kirosys.userdetails.model.UserDetails;

public interface UserDetailsService {
  
	public List<UserDetails> getAllUserDetails();
	
	public UserDetails getUserDetailsById(Long id) throws RecordNotFoundException;
	
	public UserDetails createOrUpdateUserDetails(UserDetails userDetails) throws RecordNotFoundException;
	
	public void deleteUserDetailsById(Long id) throws RecordNotFoundException;
	
}
