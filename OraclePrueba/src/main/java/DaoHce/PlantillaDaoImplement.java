package DaoHce;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modeloHce.Plantilla;

public class PlantillaDaoImplement {
	
	protected SessionFactory sessionFactory;
	private static final Logger LOGGER = LogManager.getLogger(Plantilla.class);
	
	public PlantillaDaoImplement() {
		setup();
	}
	
	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    	
		try {
		    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		    
		    
		} catch (Exception ex) {
			System.out.println(ex);
		    StandardServiceRegistryBuilder.destroy(registry);
		}
    }
 
    public void exit() {
        sessionFactory.close();
    }
 
    public void reset() {
        exit();
        setup();
    }
    
    public void create(Plantilla plantilla) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(plantilla);
        
        session.getTransaction().commit();
        
        session.close();
    }
    
    
    public Plantilla readId(Double id) { 
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        
    	Plantilla plantilla = session.get(Plantilla.class, id);
    	
    	return plantilla;
    }
    
    public List<Plantilla> read(String id, String campo) { 
	    Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        List<Plantilla> query = session.createQuery("SELECT p FROM Plantilla p WHERE p."+ campo +" = '"+id+"'").getResultList();
     
        session.getTransaction().commit();
        session.close();
        
        return query;
    }
	    
	  
    
    public void refresh(Plantilla plantilla) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.refresh(plantilla);
        
        session.close();
    }
    
 
    // Codigo para modificar un alumnos en la BD
    public void update(Plantilla plantilla) {
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(plantilla);
     
        session.getTransaction().commit();
        session.close();
        
    }  
}
