package com.gtm.DemoSpring3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanceur {

	public static void main(String[] args) {
		// 1- Chargement du conteneur et creation des beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// 2- recuperation d'un bean
		
		// 3- Traitement
		
		// 4- detruire le context
		appContext.close();
	}

}
