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

@WebServlet("/CreerDestinationServlet")
public class CreerDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationServices service = (DestinationServices) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
			String region = request.getParameter("region");
			String description = request.getParameter("description");
			Destination d = new Destination();
			d.setRegion(region);
			d.setDescription(description);
			service.create(d);

			List<Destination> destinations = service.getAllDestinations();
			request.setAttribute("destinations", destinations);
			page = "/voirdestinations.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
