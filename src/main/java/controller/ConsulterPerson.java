package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Personne;
import entities.Reuinion;
import services.Service;
import services.ServiceImpl;


@WebServlet("/ConsulterPerson")
public class ConsulterPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Service service ;
	@Override
	public void init() throws ServletException {
		service = new ServiceImpl();
	}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idperson;
		
		String idpersondelete=request.getParameter("idpersondelete");
		String idpersonupdate=request.getParameter("idpersonupdate");
		String idpersonreunion=request.getParameter("idpersonreunion");
		
		String idpersonr=request.getParameter("idpersonr");
		String idreunionr=request.getParameter("idreunionr");
		if(idpersonr!=null & idreunionr!=null) {
			int idpersonri =Integer.parseInt(idpersonr);
			int idreunionri =Integer.parseInt(idreunionr);
			if(service.personIsInReunion((long)idpersonri, (long)idreunionri)) { 
				service.deletePersonneFromReuinion((long)idpersonri, (long)idreunionri);
			}else {
				service.addPersonneToReuinion((long)idpersonri, (long)idreunionri);
			}
			List<Reuinion> nojoindedreunion=service.getAllNonJoinedReuinion((long)idpersonri);
			List<Reuinion> joindedreunion=service.getReuinionsPersonne((long)idpersonri);
			request.setAttribute("nojoindedreunion", nojoindedreunion);
			request.setAttribute("joindedreunion", joindedreunion);
			request.setAttribute("idperson", idpersonri);
			request.getRequestDispatcher("votrreReunion.jsp").forward(request, response);
		}
		
		if(idpersondelete!=null) {
			idperson=Integer.parseInt(idpersondelete);
			service.deletePersonne((long)idperson);
		}
		if(idpersonupdate!=null) {
			idperson=Integer.parseInt(idpersonupdate);
			Personne p=service.findPersonneById((long)idperson);
			request.setAttribute("personupdate", p);
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		}
		if(idpersonreunion!=null) {
			idperson=Integer.parseInt(idpersonreunion);
			List<Reuinion> nojoindedreunion=service.getAllNonJoinedReuinion((long)idperson);
			List<Reuinion> joindedreunion=service.getReuinionsPersonne((long)idperson);
			request.setAttribute("nojoindedreunion", nojoindedreunion);
			request.setAttribute("joindedreunion", joindedreunion);
			request.setAttribute("idperson", idperson);
			request.getRequestDispatcher("votrreReunion.jsp").forward(request, response);
		}
		List<Personne> listperson=service.findAllPersonnes();
		request.setAttribute("listperson", listperson);
		request.getRequestDispatcher("listperson.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
