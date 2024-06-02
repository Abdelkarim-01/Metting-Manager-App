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


@WebServlet("/ConsulterReunion")
public class ConsulterReunion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	Service service ;
	@Override
	public void init() throws ServletException {
		service = new ServiceImpl();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idreunion=request.getParameter("idreunion");
		String idpersone=request.getParameter("idpersonreunion");
		System.out.println(idpersone);
		System.out.println(idreunion);
		if(idpersone!=null && idreunion!=null) {
			
			int idre=Integer.parseInt(idreunion);
			int idp=Integer.parseInt(idpersone);
			
			service.deletePersonneFromReuinion((long)idp, (long)idre);
			
		}else if(idreunion!=null) {
			int idre=Integer.parseInt(idreunion);
			List<Personne> persones=service.getPersonnesReuinion((long)idre);
			request.setAttribute("persones", persones);
			request.setAttribute("idre", idre);
			request.getRequestDispatcher("personinreunion.jsp").forward(request, response);
		}
		
			List<Reuinion> listreunion=service.findAllReuiniona();
			request.setAttribute("listreunion", listreunion);
			request.getRequestDispatcher("listreunion.jsp").forward(request, response);
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
