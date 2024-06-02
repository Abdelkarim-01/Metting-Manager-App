package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TPERSONNES")
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonne;
	private String nomPersonne;
	private int age;
	private String email;
	
	@ManyToMany(mappedBy = "personnes", fetch = FetchType.EAGER)
	private List<Reuinion> reuinions = new ArrayList();
	
	
	public Personne(String nomPersonne, int age, String email, List<Reuinion> reuinions) {
		this.nomPersonne = nomPersonne;
		this.age = age;
		this.email = email;
		this.reuinions = reuinions;
	}

	public Personne() {}
	
	public Long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reuinion> getReuinions() {
		return reuinions;
	}

	public void setReuinions(List<Reuinion> reuinions) {
		this.reuinions = reuinions;
	}
}
