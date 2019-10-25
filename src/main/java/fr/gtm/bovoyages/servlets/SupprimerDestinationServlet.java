package fr.gtm.bovoyages.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.bovoyages.entities.DatesVoyage;
import fr.gtm.bovoyages.entities.Destination;
import fr.gtm.bovoyages.services.DestinationServices;

/**
 * Servlet implementation class SupprimerDestinationServlet
 */
@WebServlet("/SupprimerDestinationServlet")
public class SupprimerDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationServices service = (DestinationServices) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
		
		Long id = Long.valueOf(request.getParameter("id"));
		Set<DatesVoyage> datesVoyage = service.getDatesVoyageByDestinationId(id);
		DatesVoyage date = new DatesVoyage();
		
		Iterator<DatesVoyage> iter = datesVoyage.iterator();
		while (iter.hasNext()) {
			date = iter.next();
			service.deleteDatesVoyageByID(date.getId());
			iter.remove();
					    }
		
		service.findById(id).setDates(datesVoyage);
		service.delete(id);
		
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
