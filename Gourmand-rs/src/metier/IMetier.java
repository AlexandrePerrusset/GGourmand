package metier;

import java.util.List;

public interface IMetier {
	
	public double calcul();
	public String getNom();
	public void setNom(String nom);
	public List<String> getOutils();
	public void setOutils(List<String> outils);
}
