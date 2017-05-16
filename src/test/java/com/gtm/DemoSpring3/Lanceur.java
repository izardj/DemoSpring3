package com.gtm.DemoSpring3;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gtm.metier.User;
import com.gtm.service.IService;


public class Lanceur {

	public static void main(String[] args) {
		// 1- Chargement du conteneur et creation des beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// 2- recuperation d'un bean
		IService service = (IService) appContext.getBean("serviceImpl");
		User u = (User) appContext.getBean("user");
		u.setNom("Gosling");
		u.setPrenom("James");
		User u2 = (User) appContext.getBean("user");
		
		// 3- Traitement
		
		// AJOUTER USER
		//service.ajouterUser(u);
		
		// LISTER USER
		List<User> users = service.listerUsers();
		for (User user : users) {
			System.out.println(user);
		}
		
		// TROUVER USER PAR ID
		System.out.println(service.trouverUser(1));
		
		// SUPPRIMER USER		
		//service.supprimerUser(2);
		
		// LISTER USER PAR NOM
		System.out.println(service.listerParNom("Gosling"));
		
		// LISTER USER PAR MC
		List<User> usersMC = service.listerParMC("s");
		for (User user : usersMC) {
			System.out.println(user);
		}
		
		//System.out.println("bean user u: " + u.getNom());
		//System.out.println("bean user u2: " + u2.getNom());

		// 4- detruire le context
		appContext.close();
	}

}
