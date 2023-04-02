package DaoHce;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modeloHce.Plantilla;

public class PlantillaDaoImplement {
	
	protected SessionFactory sessionFactory;
	private static final Logger LOGGER = LogManager.getLogger(Plantilla.class);
	
	public PlantillaDaoImplement() {
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
 
    // codigo para guardar un alumno
    public void create(Plantilla plantilla) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(plantilla);
        
        session.getTransaction().commit();
        
        session.close();
    }
    
    // Codigo para leer un libro de la BD
    public Plantilla read(Double id) { 
    	return sessionFactory.openSession().get(Plantilla.class, id);
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
