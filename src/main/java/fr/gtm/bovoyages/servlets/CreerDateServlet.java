package fr.gtm.bovoyages.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class CreerDateServlet
 */
@WebServlet("/CreerDateServlet")
public class CreerDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationServices service = (DestinationServices) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
			String dateDepartTemp = request.getParameter("dateDepart");
			String dateRetourTemp = request.getParameter("dateRetour");
			Long id = Long.valueOf(request.getParameter("id2"));
			String prixHT = request.getParameter("prixHT");
			float prixHT2 =  Float.parseFloat(prixHT);
			String nbPlaces = request.getParameter("nbPlaces");
			int nbPlaces2 = Integer.parseInt(nbPlaces);
			DatesVoyage dates = new DatesVoyage();
			
			DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			dateDepartTemp = dateDepartTemp + " 02:00:00";
			dateRetourTemp = dateRetourTemp + " 02:00:00";
			java.util.Date dateDepart = null;
			java.util.Date dateRetour = null;
			try {
				dateDepart = formater.parse(dateDepartTemp);
				dateRetour = formater.parse(dateRetourTemp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dates.setDateDepart(dateDepart);
			dates.setDateRetour(dateRetour);
			dates.setPrixHT(prixHT2);
			dates.setNbPlaces(nbPlaces2);
			
			Destination destination = service.findById(id);
			
			Set<DatesVoyage> datesVoyage = service.getDatesVoyageByDestinationId(id);
			datesVoyage.add(dates);
			destination.setDates(datesVoyage);
			service.update(destination);

			
			Set<DatesVoyage> dateVoyage = (Set<DatesVoyage>)service.getDatesVoyageByDestinationId(id);
			request.setAttribute("destination", destination);
			request.setAttribute("dateVoyage", dateVoyage);
			
			page = "/datesdestination.jsp";
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
			rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
