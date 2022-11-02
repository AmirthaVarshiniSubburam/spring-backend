package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserDetailsRepo;

@Service
public class UserdetailsImpl implements UserDetailsService {
	@Autowired
	UserDetailsRepo userdetailsrepo;
	
	@Override
	public UserDetails registerUser(UserDetails userdetails) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		return userdetailsrepo.save(userdetails);
	}

	@Override
	public UserDetails findUserbyId(String id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userdetailsrepo.findById(id).get();
	}

	@Override
	public List<UserDetails> getAUser() {
		// TODO Auto-generated method stub
		return userdetailsrepo.findAll();
	}

	@Override
	public UserDetails deleteAUser(String id) {
		// TODO Auto-generated method stub
		UserDetails deleteUserDetails =  null;
		
		Optional optional = userdetailsrepo.findById(id);
		
		if(optional.isPresent()) {
			deleteUserDetails = userdetailsrepo.findById(id).get();
			userdetailsrepo.deleteById(id);
		}
		
		return deleteUserDetails;
	}
	
	@Override
	public UserDetails updateAUser(UserDetails userdetails) {
		// TODO Auto-generated method stub
		UserDetails updatedUserDetails =  null;
		
		Optional optional = userdetailsrepo.findById(userdetails.getId());
		if (optional.isPresent()) {
			UserDetails getUser = userdetailsrepo.findById(userdetails.getId()).get();
			getUser.setEmailid(userdetails.getEmailid());
			getUser.setName(userdetails.getName());
			getUser.setMobno(userdetails.getMobno());
			getUser.setAccno(userdetails.getAccno());			
			getUser.setPassword(userdetails.getPassword());			
			updatedUserDetails = userdetailsrepo.save(getUser);
		}
		
		return updatedUserDetails;
	}

}
