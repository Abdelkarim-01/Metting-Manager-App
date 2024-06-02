package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "TREUINIONS")
public class Reuinion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReuinion;
	private String titre;
	private int durreeReuinion;
	private Date dateReuinion;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "REUINION_PERSONNE",
	        joinColumns = @JoinColumn(name = "REUINION_ID"),
	        inverseJoinColumns = @JoinColumn(name = "PERSONNE_ID")
	    )
	private List<Personne> personnes = new ArrayList();
	
	
	public Reuinion() {}
	public Reuinion(String titre, int durreeReuinion, Date dateReuinion, List<Personne> personnes) {
		this.titre = titre;
		this.durreeReuinion = durreeReuinion;
		this.dateReuinion = dateReuinion;
		this.personnes = personnes;
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	
	public Long getIdReuinion() {
		return idReuinion;
	}
	public void setIdReuinion(Long idReuinion) {
		this.idReuinion = idReuinion;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getDurreeReuinion() {
		return durreeReuinion;
	}
	public void setDurreeReuinion(int durreeReuinion) {
		this.durreeReuinion = durreeReuinion;
	}
	
		public Date getDateReuinion() {
		return dateReuinion;
	}
	public void setDateReuinion(Date dateReuinion) {
		this.dateReuinion = dateReuinion;
	}
}
