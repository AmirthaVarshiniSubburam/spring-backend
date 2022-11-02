package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserDetailsRepo;

//@Service
//public class MyUserDetailService implements UserDetailsService {
//	
//	@Autowired
//	UserDetailsRepo userdetailsrepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String emailid) throws UsernameNotFoundException {
//		
//		 UserDetails userdetails = userdetailsrepo.findById(emailid).get();
//		 
//		return new User(userdetails.getId(), userdetails.getPassword(), new ArrayList<>()) ;
//	}
//
//	}
