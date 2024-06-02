package services;

import java.util.List;

import javax.transaction.SystemException;

import entities.Personne;
import entities.Reuinion;

public interface Service {
	public void addNewPersonne(Personne p);
	public void updatePersonne(Personne p);
	public void deletePersonne(Long idPersonne);
	
	public void addNewReuinion(Reuinion reuinion);
	public void updateReuinion(Reuinion p);
	public void deleteReuinion(Long idReuinion);
	
	public Personne findPersonneById(Long id);
	public Reuinion findReuinionById(Long idReuinion);
	
	public List<Reuinion> findReuinionByMC(String mc);
	public List<Personne> findPersonneByMC(String mc);
	
	public boolean personIsInReunion(Long idPersonne, Long idReunion);
	public void addPersonneToReuinion(Long idPersonne, Long idReuinion);
	public void deletePersonneFromReuinion(Long idPersonne, Long idReuinion) ;
    
    public List<Reuinion> findAllReuiniona();
	public List<Personne> findAllPersonnes();
	
	public List<Reuinion> getReuinionsPersonne(Long id);
	public List<Personne> getPersonnesReuinion(Long id);
	
	public List<Reuinion> getAllNonJoinedReuinion(Long id);
	
	
	
}
