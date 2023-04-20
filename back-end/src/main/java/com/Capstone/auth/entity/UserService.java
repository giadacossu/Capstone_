package com.Capstone.auth.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.auth.repository.UserRepository;
import com.Capstone.piatti.PiattiTipici;
import com.Capstone.piatti.Provenienza;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired UserRepository repo;
	
	public User createUser(User p) {
		if(repo.existsByUsername(p.getUsername())) {
			 throw new EntityExistsException(" User  già presente!");
		}else if(repo.existsByEmail(p.getEmail())) {
			 throw new EntityExistsException(" User  già presente!");
		}
	repo.save(p);
	System.out.println(p.getName()+" creato");
		return p;
	}
	
	public List<User> getAllUser() {
		return (List<User>) repo.findAll();
	}
	
	public User getUserById(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questo User non esiste");
		}
		return repo.findById(id).get();
	}
		
	public User getUserByEmail(String e) {
		if(!repo.existsByEmail(e)) {
			 throw new EntityNotFoundException("questo User non esiste");
		}
		return repo.findByEmail(e).get();
	}
		
	public User updateUser(User p) {
		if(!repo.existsById(p.getId())) {
			 throw new EntityNotFoundException("questo User non esiste");
		}
		repo.save(p);
		return p;
	}
	
	public String removeUser(Long id) {
		if(!repo.existsById(id)) {
			 throw new EntityNotFoundException("questo User non esiste");
		}
		repo.deleteById(id);
		return "User eliminato";
	}
}
