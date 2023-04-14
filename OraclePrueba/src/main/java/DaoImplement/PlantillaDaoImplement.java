package DaoImplement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Dao.PlantillaDao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modeloHce.Plantilla;

public class PlantillaDaoImplement implements PlantillaDao{
	
	protected SessionFactory sessionFactory;
	private static final Logger LOGGER = LogManager.getLogger(Plantilla.class);
	
	public PlantillaDaoImplement() {
		setup();
	}

    @Override
    public void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    	
		try {
		    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		    
		    
		} catch (Exception ex) {
			System.out.println(ex);
		    StandardServiceRegistryBuilder.destroy(registry);
		}
    }

    @Override
    public void exit() {
        sessionFactory.close();
    }

    @Override
    public void reset() {
        exit();
        setup();
    }

    @Override
    public void create(Plantilla plantilla) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(plantilla);
        
        session.getTransaction().commit();
        
        session.close();
    }

    @Override
    public Plantilla read(Double idPlantilla) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
    	Plantilla plantilla = session.get(Plantilla.class, idPlantilla);
    	
    	return plantilla;
    }

    @Override
    public List<Plantilla> read(String idPlantilla, String campo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        List<Plantilla> query = session.createQuery("SELECT p FROM Plantilla p WHERE p."+ campo +" = '"+idPlantilla+"'").getResultList();
     
        session.getTransaction().commit();
        session.close();
        
        return query;
    }

    @Override
    public void update(Plantilla plantilla) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(plantilla);
     
        session.getTransaction().commit();
        session.close();
    }
}
