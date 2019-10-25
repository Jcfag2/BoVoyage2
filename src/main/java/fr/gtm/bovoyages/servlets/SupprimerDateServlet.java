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


@WebServlet("/SupprimerDateServlet")
public class SupprimerDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationServices service = (DestinationServices) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
		
		Long id = Long.valueOf(request.getParameter("id"));
		Long id2 = Long.valueOf(request.getParameter("id2"));
		
		service.deleteDatesVoyageByID(id);
		
		Set<DatesVoyage> dateVoyage = (Set<DatesVoyage>)service.getDatesVoyageByDestinationId(id2);
		Destination destination = service.findById(id2);
		
		request.setAttribute("destination", destination);
		request.setAttribute("dateVoyage", dateVoyage);
		
		page = "/datesdestination.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
