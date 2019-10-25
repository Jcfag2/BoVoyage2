package fr.gtm.bovoyages.servlets;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import fr.gtm.bovoyages.servlets.Constantes;
import fr.gtm.bovoyages.services.DestinationServices;

@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger("destinations");

    public void contextDestroyed(ServletContextEvent sce)  { 
    	EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
    	emf.close();
    	LOG.info(">>> EMF fermé");
    	LOG.info(">>> Application detruite");
    }


    public void contextInitialized(ServletContextEvent sce)  { 
        LOG.info(">>> Application démarée");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bovoyages");
        LOG.info(">>> EMF: "+emf);
        ServletContext application = sce.getServletContext();
        application.setAttribute(Constantes.EMF, emf);
        DestinationServices service = new DestinationServices(emf);
        LOG.info(">>> Service: "+service);
        application.setAttribute(Constantes.DESTINATION_SERVICE, service);
    }
    
   
	
}
