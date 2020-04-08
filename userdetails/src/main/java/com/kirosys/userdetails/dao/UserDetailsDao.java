package com.kirosys.userdetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kirosys.userdetails.model.UserDetails;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Long>{

	
}
