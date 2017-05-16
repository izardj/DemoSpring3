package com.gtm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gtm.metier.User;

@Transactional
@Repository
public class DaoImplHibernate implements IDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void ajouterUser(User u) {
		getSession().save(u);
		System.out.println("AJOUTER A PARTIR DE HIBERNATE");
	}

	@Override
	public List<User> listerUsers() {
		String req = "FROM User";
		Query q = getSession().createQuery(req);
		return q.list();
	}

	@Override
	public void supprimerUser(long id) {
		getSession().delete(trouverUser(id));
	}

	@Override
	public User trouverUser(long id) {
		return (User) getSession().get(User.class, id);
	}

	@Override
	public List<User> listerParMC(String nom) {
		String req = "FROM User AS u WHERE u.nom LIKE :nom";
		Query q =getSession().createQuery(req);
		q.setParameter("nom", "%"+nom+"%");
		return q.list();
	}

	@Override
	public User listerParNom(String nom) {
		String req = "FROM User AS u WHERE u.nom LIKE :nom";
		Query q =getSession().createQuery(req);
		q.setParameter("nom", nom);
		q.setMaxResults(1);
		return (User) q.uniqueResult();
	}

}
