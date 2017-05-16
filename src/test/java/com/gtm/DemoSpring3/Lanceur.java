package com.gtm.DemoSpring3;

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
		User u2 = (User) appContext.getBean("user");
		
		// 3- Traitement
		service.ajouterUser(u);
		
		u.setNom("toto");
		System.out.println("bean user u: " + u.getNom());
		System.out.println("bean user u2: " + u2.getNom());

		// 4- detruire le context
		appContext.close();
	}

}
