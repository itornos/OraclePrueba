package DaoHce;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modeloHce.TipoDatoBasico;

public class TipoDatoBasicoDaoImplement {
	
	protected SessionFactory sessionFactory;
	private static final Logger LOGGER = LogManager.getLogger(TipoDatoBasico.class);
	
	public TipoDatoBasicoDaoImplement() {
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
 
    public void create(TipoDatoBasico tipoDatoBasico) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(tipoDatoBasico);
        
        session.getTransaction().commit();
        
        session.close();
    }
    
    public List<TipoDatoBasico> read() { 
    	Session session = sessionFactory.openSession();
    	
    	List<TipoDatoBasico> lista = session.createQuery("SELECT p FROM TipoDatoBasico p").getResultList();
    	
    	session.close();
    	
    	return lista;
    } 
 
    // Codigo para modificar un alumnos en la BD
    public void update(TipoDatoBasico tipoDatoBasico) {
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(tipoDatoBasico);
     
        session.getTransaction().commit();
        session.close();
        
    }
}
