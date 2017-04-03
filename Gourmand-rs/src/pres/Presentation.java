package pres;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.IMetier;

public class Presentation {

	public static void main(String[] args) { 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-ioc.xml"});
		
		IMetier metier = (IMetier) context.getBean("metier");
		metier.setNom("new nom");
		System.out.println(metier.getNom());
		
		IMetier metier2 = (IMetier) context.getBean("metier");
		metier2.setNom("nom metier 2");
		System.out.println(metier.getNom());
		
		System.out.println(metier.calcul());
		
		for (String outil : metier.getOutils()) {
			System.out.println(outil);
		}
	}
}
