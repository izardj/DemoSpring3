package com.gtm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gtm.metier.User;

@Repository
public class DaoImplHibernate implements IDao {

	@Override
	public void ajouterUser(User u) {
		System.out.println("AJOUTER A PARTIR DE HIBERNATE");
	}

	@Override
	public List<User> listerUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerUser(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User trouverUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listerParMC(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listerParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
