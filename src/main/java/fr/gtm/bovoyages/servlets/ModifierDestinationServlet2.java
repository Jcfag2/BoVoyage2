package fr.gtm.bovoyages.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.gtm.bovoyages.entities.Destination;
import fr.gtm.bovoyages.services.DestinationServices;

@WebServlet("/ModifierDestinationServlet2")
public class ModifierDestinationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationServices service = (DestinationServices) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
		
		Long id = Long.valueOf(request.getParameter("id"));
		Destination destination = service.findById(id);
		
		destination.setRegion(request.getParameter("region"));
		destination.setDescription(request.getParameter("description"));

		service.update(destination);
		
		List<Destination> destinations = service.getAllDestinations();
		request.setAttribute("destinations", destinations);
		page = "/voirdestinations.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
