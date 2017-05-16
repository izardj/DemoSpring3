package com.gtm.dao;

import java.util.List;

import com.gtm.metier.User;

public interface IDao {

	public void ajouterUser(User u);

	public List<User> listerUsers();

	public void supprimerUser(long id);

	public User trouverUser(long id);

	public List<User> listerParMC(String nom);
	
	public User listerParNom(String nom);
}
