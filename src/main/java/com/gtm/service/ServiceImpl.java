package com.gtm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtm.dao.springdata.UserRepository;
import com.gtm.metier.User;

@Service
public class ServiceImpl implements IService {

	@Autowired
	//@Qualifier("daoImplJPA")
	//private IDao dao;
	UserRepository userRepository;
	
	@Override
	public void ajouterUser(User u) {
		//dao.ajouterUser(u);
		userRepository.save(u);
	}

	@Override
	public List<User> listerUsers() {
		//return dao.listerUsers();
		return userRepository.findAll();
	}

	@Override
	public void supprimerUser(long id) {
		//dao.supprimerUser(id);
		userRepository.delete(id);
	}

	@Override
	public User trouverUser(long id) {
		//return dao.trouverUser(id);
		return userRepository.findOne(id);
	}

	@Override
	public List<User> listerParMC(String nom) {
		//return dao.listerParMC(nom);
		return userRepository.findByNomContaining(nom);
		//return userRepository.findByMC(nom);
	}

	@Override
	public User listerParNom(String nom) {
		return userRepository.findFirstByNom(nom);
	}

}
