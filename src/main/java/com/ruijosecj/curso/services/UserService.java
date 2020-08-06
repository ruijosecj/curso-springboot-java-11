package com.ruijosecj.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruijosecj.curso.entities.User;
import com.ruijosecj.curso.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj =  userRepository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User upDate(Long id, User obj) {
		User returnUser = userRepository.getOne(id);
		upDateData(returnUser, obj);
		return userRepository.save(returnUser);
	}

	private void upDateData(User returnUser, User obj) {
		returnUser.setName(obj.getName());
		returnUser.setEmail(obj.getEmail());
		returnUser.setPhone(obj.getPhone());
	}
}
