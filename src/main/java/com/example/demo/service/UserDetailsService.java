package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserDetails;

public interface UserDetailsService {
	
	public UserDetails registerUser(UserDetails userdetails) throws UserAlreadyExistsException;//post request to save the record
	public UserDetails findUserbyId(String id) throws UserNotFoundException;//get request to retrieve a record
	public List<UserDetails> getAUser();//get request to retrieve all records
	public UserDetails deleteAUser (String emailid);
	public UserDetails updateAUser(UserDetails userdetails); //PUT or patch request
	

}
