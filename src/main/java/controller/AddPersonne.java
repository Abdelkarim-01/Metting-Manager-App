package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

@WebServlet("/AddPersonne")
public class AddPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service ;
	@Override
	public void init() throws ServletException {
		service = new ServiceImpl();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idperson=req.getParameter("idperson");
		String nomPersonne =req.getParameter("nomPersonne");
		String age =req.getParameter("age");
		String email = req.getParameter("email");
		
		String title = req.getParameter("titre");
		String duree = req.getParameter("duree");
		String date = req.getParameter("date");

		
		
		if(nomPersonne!=null && age !=null && email!=null) {
			if(idperson==null) {
				int ageNum = Integer.parseInt(age);
				Personne p = new Personne();
				p.setAge(ageNum);
				p.setEmail(email);
				p.setNomPersonne(nomPersonne);
				service.addNewPersonne(p);
			}else {
				int idper=Integer.parseInt(idperson);
				int ageNum = Integer.parseInt(age);
				Personne p = new Personne();
				p.setIdPersonne((long)idper);
				p.setAge(ageNum);
				p.setEmail(email);
				p.setNomPersonne(nomPersonne);
				service.updatePersonne(p);
				List<Personne> listperson=service.findAllPersonnes();
				req.setAttribute("listperson", listperson);
				req.getRequestDispatcher("listperson.jsp").forward(req, resp);
			}

		}
		
		if(title!=null && duree !=null & date!=null) {
			try {
			int numInt = Integer.parseInt(duree);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	        
			java.util.Date parsedDate = dateFormat.parse(date);
			java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
			Reuinion r = new Reuinion();
			r.setDateReuinion(sqlDate);
			r.setTitre(title);
			r.setDurreeReuinion(numInt);
			service.addNewReuinion(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		resp.sendRedirect("/ProjetReunion/HomePage.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
