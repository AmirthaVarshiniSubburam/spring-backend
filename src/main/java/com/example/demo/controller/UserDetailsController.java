package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.JWTRequest;
import com.example.demo.model.JWTResponse;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserDetailsService;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class UserDetailsController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping("/userdetails")
	public ResponseEntity<UserDetails> saveNewUser(@RequestBody UserDetails userdetails) throws UserAlreadyExistsException{
	return new ResponseEntity<UserDetails>(userDetailsService.registerUser(userdetails),HttpStatus.CREATED);
	}
	
	@GetMapping("/netflixusers")
	public ResponseEntity<List<UserDetails>> getAllUser(){
 return new ResponseEntity<List<UserDetails>> (userDetailsService.getAUser(), HttpStatus.OK);
	}
	@GetMapping("/netflixusers/{id}")
	public ResponseEntity<UserDetails> findAUserbyId(@PathVariable String id) throws UserNotFoundException{
		return new ResponseEntity<UserDetails>(userDetailsService.findUserbyId(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/netflixusers/{username}")
	public ResponseEntity<UserDetails> deleteAUserbyId(@PathVariable String username){
		return new ResponseEntity<UserDetails>(userDetailsService.deleteAUser(username),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/netflixusers")
	public ResponseEntity<UserDetails> updateAUser(@RequestBody UserDetails updatedNetflixUser){
		return new ResponseEntity<UserDetails>(userDetailsService.updateAUser(updatedNetflixUser),HttpStatus.CREATED);
	}
	
//	@PostMapping("/login")
//	public JWTResponse login(@RequestBody JWTRequest request) throws Exception {
//		
//try {
//			
//			manager.authenticate(
//					new UsernamePasswordAuthenticationToken(request.getEmailid(), request.getPassword())	
//					);
//			
//		}
//		catch( BadCredentialsException e ){
//			throw new Exception("Wrong_Emailid_or_Password");
//		}
//		
//		UserDetails userdetail = userDetailsService.loadUserByEmailid(request.getEmailid());
//		
//		String generateToken = jwtUtitlity.generateToken(userdetail);
//		return new JWTResponse(generateToken);
//
//		
//	}
//	
	
	
	
	
}
