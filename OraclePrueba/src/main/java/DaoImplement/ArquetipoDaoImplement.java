package DaoImplement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Dao.ArquetipoDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modeloHce.Arquetipo;

public class ArquetipoDaoImplement implements ArquetipoDao{
	
	protected SessionFactory sessionFactory;
	private static final Logger LOGGER = LogManager.getLogger(Arquetipo.class);
	
	public ArquetipoDaoImplement() {
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
    public void create(Arquetipo arquetipo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(arquetipo);
        
        session.getTransaction().commit();
        
        session.close();
    }
    
    @Override
    public Arquetipo read(Double idArquetipo) { 
    	return sessionFactory.openSession().get(Arquetipo.class, idArquetipo);
    }    
 
    @Override
    public void update(Arquetipo arquetipo) {
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(arquetipo);
     
        session.getTransaction().commit();
        session.close();
        
    }
}
