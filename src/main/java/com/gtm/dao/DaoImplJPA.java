package com.gtm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gtm.metier.User;

@Repository
@Transactional
public class DaoImplJPA implements IDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void ajouterUser(User u) {
		em.persist(u);
		System.out.println("AJOUTER A PARTIR DE JPA");
	}

	@Override
	public List<User> listerUsers() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	@Override
	public void supprimerUser(long id) {
		em.remove(trouverUser(id));
	}

	@Override
	public User trouverUser(long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> listerParMC(String nom) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.nom LIKE :nom");
		q.setParameter("nom", "%"+nom+"%");
		return q.getResultList();
	}

	@Override
	public User listerParNom(String nom) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.nom LIKE :nom");
		q.setParameter("nom", nom);
		q.setMaxResults(1);
		return (User) q.getSingleResult();
	}

}
