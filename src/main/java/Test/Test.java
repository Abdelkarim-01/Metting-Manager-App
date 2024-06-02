package Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.SystemException;

import org.hibernate.Session;

import com.mysql.cj.util.DnsSrv.SrvRecord;

import entities.Personne;
import entities.Reuinion;
import services.Service;
import services.ServiceImpl;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) throws SystemException {
		
		
//		Personne p1 = new Personne("Otmane", 17, "b@gmail.com", new ArrayList<Reuinion>());
//		Personne p2 = new Personne("Mohamed", 17, "mohamed@gmail.com", new ArrayList<Reuinion>());
//		Personne p3 = new Personne("Salah", 17, "salah@gmail.com", new ArrayList<Reuinion>());
//		Personne p4 = new Personne("Redouane", 17, "redouane@gmail.com", new ArrayList<Reuinion>());
//		
//		Reuinion r1 = new Reuinion("Cous JEE Hibernate", 3, new Date(2022, 7, 5), new ArrayList<Personne>());
//		Reuinion r2 = new Reuinion("Cous JEE Hibernate", 3, new Date(2022, 7, 5), new ArrayList<Personne>());
//		Reuinion r3 = new Reuinion("Cous JEE Hibernate", 3, new Date(2022, 7, 5), new ArrayList<Personne>());
//		Reuinion r4 = new Reuinion("Cous JEE Hibernate", 3, new Date(2022, 7, 5), new ArrayList<Personne>());
//		
//		p1.getReuinions().add(r4);
//		r4.getPersonnes().add(p1);
//		p2.getReuinions().add(r1);
//		r1.getPersonnes().add(p2);
//		p3.getReuinions().add(r2);
//		r2.getPersonnes().add(p3);
//
//	
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		session.save(r1);
//		session.save(r2);
//		session.save(r3);
//		session.save(r4);
//		
//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
//		session.save(p4);
//		
//		session.getTransaction().commit();
		
		Service service = new ServiceImpl();
		
//		Reuinion r=service.findReuinionById(1L);
//		p.getReuinions().add(r);
//		service.updatePersonne(p);
//		
//		List<Personne> personnes=service.findAllPersonnes();
//		if(personnes.isEmpty()) {
//			System.out.println("le personne est nulle");
//		}else {
//			for(Personne pr: personnes) {
//				System.out.println(pr.getIdPersonne());
//			}
//		}
				
	}
}
