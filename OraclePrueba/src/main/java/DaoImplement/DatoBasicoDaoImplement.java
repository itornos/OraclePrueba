package DaoImplement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modeloHce.DatoBasico;

public class DatoBasicoDaoImplement {
	
	protected SessionFactory sessionFactory;
	private static final Logger LOGGER = LogManager.getLogger(DatoBasico.class);
	
	public DatoBasicoDaoImplement() {
		setup();
	}
	
	public void setup(){
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
 
    public void create(DatoBasico datoBasico) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(datoBasico);
        
        session.getTransaction().commit();
        
        session.close();
    }
    
    public DatoBasico read(Double id) { 
    	return sessionFactory.openSession().get(DatoBasico.class, id);
    }    
 
    // Codigo para modificar un alumnos en la BD
    public void update(DatoBasico datoBasico) {
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(datoBasico);
     
        session.getTransaction().commit();
        session.close();
        
    }
}
