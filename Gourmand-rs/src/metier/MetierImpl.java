package metier;

import java.util.List;

import dao.IDao;


public class MetierImpl implements IMetier {
	private IDao dao;
	private double rnd;
	private String nom;
	private List<String> outils;

	public List<String> getOutils() {
		return outils;
	}


	public void setOutils(List<String> outils) {
		this.outils = outils;
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public double calcul() {
		double nb = 2*dao.getValue();
		return rnd*nb;
	}
	
	public void init() {
		rnd = Math.random();
	}

	
	public double getRnd() {
		return rnd;
	}

	
	public void setRnd(double rnd) {
		this.rnd = rnd;
	}

	public String getNom() {
		return nom;
	}
	

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
