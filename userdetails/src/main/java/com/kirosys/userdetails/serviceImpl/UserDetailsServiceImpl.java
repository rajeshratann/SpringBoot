package com.kirosys.userdetails.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirosys.userdetails.dao.UserDetailsDao;
import com.kirosys.userdetails.exception.RecordNotFoundException;
import com.kirosys.userdetails.model.UserDetails;
import com.kirosys.userdetails.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsDao userDetailsdao; 
	
	@Override
	public List<UserDetails> getAllUserDetails() {
		
		List<UserDetails> allUserDetailsList = userDetailsdao.findAll();
		
		 if(allUserDetailsList.size()>0) {
			 return  allUserDetailsList;
		 }else
		 {
			 return new ArrayList<UserDetails>();
		 }
		
	}

	@Override
	public UserDetails getUserDetailsById(Long id) throws RecordNotFoundException {
		 Optional<UserDetails> userDetailsById =  userDetailsdao.findById(id);
		 if(userDetailsById.isPresent()) {
			 return userDetailsById.get(); 
		 }else {
			 throw new RecordNotFoundException("UserDetails not found for ID: "+id);
		 }
		
	}

	@Override
	public UserDetails createOrUpdateUserDetails(UserDetails userDetails) throws RecordNotFoundException {
		Optional<UserDetails> userDetailsById =  userDetailsdao.findById(userDetails.getId());
		 if(userDetailsById.isPresent()) {
			 UserDetails updatedUserDetails = userDetailsById.get(); 
			 updatedUserDetails.setFirstName(userDetails.getFirstName());
			 updatedUserDetails.setLastName(userDetails.getLastName());
			 updatedUserDetails.setEmail(userDetails.getEmail());
			 updatedUserDetails.setDob(userDetails.getDob());
			 updatedUserDetails.setContactNo(userDetails.getContactNo());
			 updatedUserDetails.setImage(userDetails.getImage());
			 return userDetailsdao.save(updatedUserDetails);
		 }else {
			 return userDetailsdao.save(userDetails);
		 }
		
	}

	@Override
	public void deleteUserDetailsById(Long id) throws RecordNotFoundException {
		Optional<UserDetails> userDetailsById =  userDetailsdao.findById(id);
		 if(userDetailsById.isPresent()) {	
			 userDetailsdao.deleteById(id);
		 }else {
			 throw new RecordNotFoundException("UserDetails not found for ID: "+id);
		 }
	}

}
