package com.ruijosecj.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ruijosecj.curso.entities.User;
import com.ruijosecj.curso.repositories.UserRepository;
import com.ruijosecj.curso.services.exceptions.DatabaseException;
import com.ruijosecj.curso.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj =  userRepository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User upDate(Long id, User obj) {
		try {
			User returnUser = userRepository.getOne(id);
			upDateData(returnUser, obj);
			return userRepository.save(returnUser);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void upDateData(User returnUser, User obj) {
		returnUser.setName(obj.getName());
		returnUser.setEmail(obj.getEmail());
		returnUser.setPhone(obj.getPhone());
	}
}
