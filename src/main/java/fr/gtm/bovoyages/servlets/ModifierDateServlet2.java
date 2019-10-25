package fr.gtm.bovoyages.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
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
 * Servlet implementation class ModifierDateServlet2
 */
@WebServlet("/ModifierDateServlet2")
public class ModifierDateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationServices service = (DestinationServices) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
			String dateDepartTemp = request.getParameter("dateDepart");
			String dateRetourTemp = request.getParameter("dateRetour");
			Long id = Long.valueOf(request.getParameter("id2"));
			Long idDate = Long.valueOf(request.getParameter("id"));
			String prixHT = request.getParameter("prixHT");
			float prixHT2 =  Float.parseFloat(prixHT);
			String nbPlaces = request.getParameter("nbPlaces");
			int nbPlaces2 = Integer.parseInt(nbPlaces);
			
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
			
			
			Destination destination = service.findById(id);
			
			Set<DatesVoyage> datesVoyage = service.getDatesVoyageByDestinationId(id);
			//datesVoyage.add(dates);
			
			
			Iterator<DatesVoyage> iter = datesVoyage.iterator();
			while (iter.hasNext()) {
				DatesVoyage date2 = iter.next();
				if(date2.getId()==idDate) {
					date2.setDateDepart(dateDepart);
					date2.setDateRetour(dateRetour);
					date2.setPrixHT(prixHT2);
					date2.setNbPlaces(nbPlaces2);
				}
			}
			
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

		doGet(request, response);
	}

}
