 package services;


import java.math.BigInteger;

import java.util.List;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;

import entities.Personne;
import entities.Reuinion;
import net.bytebuddy.asm.Advice.Return;
import util.HibernateUtil;

public class ServiceImpl implements Service{
	

	@Override
	public void addNewPersonne(Personne p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		try {
			session.save(p);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deletePersonne(Long pidPersonne) {
		Personne p = findPersonneById(pidPersonne);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			if(p !=null) {
				List<Reuinion> reuinions = p.getReuinions();
				reuinions.forEach(e -> {
					e.getPersonnes().remove(p);
					session.update(e);
				});
				session.delete(p);
			}
			else {
				throw new RuntimeException("Can not delete Personne with id : " + pidPersonne);
			}
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void addNewReuinion(Reuinion reuinion) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		try {
			session.save(reuinion);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public void deleteReuinion(Long idReuinion) {
		Reuinion r = findReuinionById(idReuinion);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	try {
		
		session.beginTransaction();
		if(r !=null) {
			List<Personne> personnes = r.getPersonnes();
			personnes.forEach(e -> {
				e.getReuinions().remove(r);
				session.update(e);
			});
			session.delete(r);
		}
		else {
			throw new RuntimeException("Can not delete Personne with id : " + idReuinion);
		}
		
		session.getTransaction().commit();
	}catch(Exception e) {
		session.getTransaction().rollback();
		System.out.println(e.getMessage());
	}
	}

	@Override
	public Personne findPersonneById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		try {
			
			Object obj = session.get(Personne.class, id);
			if(obj == null) {
				throw new RuntimeException("Personne not found !!!!!!");
			}
			Personne p = (Personne)obj;
			session.getTransaction().commit();
			return p;
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Reuinion findReuinionById(Long idReuinion) {
		Reuinion p = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		try {
			Object obj = session.get(Reuinion.class, idReuinion);
			if(obj == null) {
				throw new RuntimeException("Reuinion with id "+ Long.valueOf(idReuinion) +" not exist");
			}
			p = (Reuinion)obj;
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	
	@Override
	public void updatePersonne(Personne p) {
		Personne pExist = findPersonneById(p.getIdPersonne());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		if(pExist == null) {
			throw new RuntimeException("Cannot update Personne : " + p.getNomPersonne());
		}else {
			session.update(p);
		}
		session.getTransaction().commit();
	}
	
	@Override
	public void updateReuinion(Reuinion p) {
		Reuinion pExist = findReuinionById(p.getIdReuinion());
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		if(pExist == null) {
			throw new RuntimeException("Cannot update Personne : " + p.getTitre());
		}else {
			session.update(p);
		}
		session.getTransaction().commit();
	}
	
	@Override
	public List<Reuinion> findReuinionByMC(String mc) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select p from Reuinion p where p.titre Like :x");
		req.setString("x","%" + mc + "%");
		List<Reuinion> reuinions = req.list();
		session.getTransaction().commit();
		return reuinions;
	}

	@Override
	public List<Personne> findPersonneByMC(String mc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select p from Personne p where p.nomPersonne Like :x");
		req.setString("x", "%" + mc + "%");
		List<Personne> personnes = req.list();
		session.getTransaction().commit();
		return personnes;
	}

	@Override
	public List<Reuinion> findAllReuiniona() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select r from Reuinion r");
		List<Reuinion> reuinions = req.list();
		session.getTransaction().commit();
		return reuinions;
	}

	@Override
	public List<Personne> findAllPersonnes() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select r from Personne r");
		List<Personne> personnes = req.list();
		session.getTransaction().commit();
		return personnes;
	}
	
	@Override
	public void addPersonneToReuinion(Long idPersonne, Long idReuinion) {
		Personne p = findPersonneById(idPersonne);
		Reuinion r = findReuinionById(idReuinion);
		
		r.getPersonnes().add(p);
		p.getReuinions().add(r);
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(p);
		session.update(r);
		session.getTransaction().commit();
	}

//	@Override
//	public void deletePersonneFromReuinion(Long idPersonne, Long idReuinion) {
//		Reuinion r = findReuinionById(idReuinion);
//		Personne p = findPersonneById(idPersonne);
//		if(r!=null && p!=null) {
//			r.getPersonnes().remove(p);
//		}
//		
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		session.update(r);
//		session.getTransaction().commit();
//	}
	
	@Override
	public void deletePersonneFromReuinion(Long idPersonne, Long idReuinion){
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	    try {
	    	session.beginTransaction();

	        String sql = "DELETE FROM reuinion_personne " +
	                     "WHERE REUINION_ID = :reuinionId AND PERSONNE_ID = :personneId";

	        session.createSQLQuery(sql)
	            .setParameter("reuinionId", idReuinion)
	            .setParameter("personneId", idPersonne)
	            .executeUpdate();
	        
	        session.getTransaction().commit();
	    } catch (Exception e) {
	    	System.out.println(e);
	    } 
	    
	}
	
	@Override
	public boolean personIsInReunion(Long idPersonne, Long idReunion) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    boolean isInReunion = false;

	    try {
	        session.beginTransaction();

	        String sql = "SELECT COUNT(*) FROM reuinion_personne " +
	                     "WHERE REUINION_ID = :reunionId AND PERSONNE_ID = :personneId";

	        BigInteger count = (BigInteger) session.createSQLQuery(sql)
	            .setParameter("reunionId", idReunion)
	            .setParameter("personneId", idPersonne)
	            .uniqueResult();

	        isInReunion = count.intValue() > 0;

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        System.out.println(e);
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	    } finally {
	        if (session.isOpen()) {
	            session.close();
	        }
	    }

	    return isInReunion;
	}


	@Override
	public List<Reuinion> getReuinionsPersonne(Long id) {
		Personne p = findPersonneById(id);		
		return p.getReuinions();
	}

	@Override
	public List<Personne> getPersonnesReuinion(Long id) {
		Reuinion r = findReuinionById(id);
		return r.getPersonnes();
	}

	@Override
	public List<Reuinion> getAllNonJoinedReuinion(Long id) {
		Personne p = findPersonneById(id);
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.beginTransaction();

	    try {

	        // Corrected HQL query
	        String hql = "FROM Reuinion r WHERE :personne NOT MEMBER OF r.personnes";
	        Query query = session.createQuery(hql);
	        query.setParameter("personne", p);

	        List<Reuinion> resultList = query.list();
	        session.getTransaction().commit();

	        return resultList;
	    } catch (Exception e) {
	        session.getTransaction().rollback();
	        System.out.println(e.getMessage());
	        return null;
	    }
	}

}
