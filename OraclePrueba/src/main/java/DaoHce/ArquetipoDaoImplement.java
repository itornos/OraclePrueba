package DaoHce;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modeloHce.Arquetipo;

public class ArquetipoDaoImplement {
	
	protected SessionFactory sessionFactory;
	private static final Logger LOGGER = LogManager.getLogger(Arquetipo.class);
	
	public ArquetipoDaoImplement() {
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
    public void create(Arquetipo arquetipo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(arquetipo);
        
        session.getTransaction().commit();
        
        session.close();
    }
    
    // Codigo para leer un libro de la BD
    public Arquetipo read(Double id) { 
    	return sessionFactory.openSession().get(Arquetipo.class, id);
    }
    
    public void refresh(Arquetipo arquetipo) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.refresh(arquetipo);
        
        session.close();
    }
    
 
    // Codigo para modificar un alumnos en la BD
    public void update(Arquetipo arquetipo) {
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(arquetipo);
     
        session.getTransaction().commit();
        session.close();
        
    }  
}
