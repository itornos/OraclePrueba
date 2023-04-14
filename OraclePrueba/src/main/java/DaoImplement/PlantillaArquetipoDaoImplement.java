package DaoImplement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modeloHce.Arquetipo;
import modeloHce.PlantillaArquetipo;

public class PlantillaArquetipoDaoImplement {
	
	protected SessionFactory sessionFactory;
	private static final Logger LOGGER = LogManager.getLogger(Arquetipo.class);
	
	public PlantillaArquetipoDaoImplement() {
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
    public void create(PlantillaArquetipo arquetipo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(arquetipo);
        
        session.getTransaction().commit();
        
        session.close();
    }
    
    // Codigo para leer un libro de la BD
    public PlantillaArquetipo read(PlantillaArquetipo p) { 
    	return sessionFactory.openSession().get(PlantillaArquetipo.class, p.getPk());
    }
    
    public void refresh(PlantillaArquetipo arquetipo) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.refresh(arquetipo);
        
        session.close();
    }
    
 
    // Codigo para modificar un alumnos en la BD
    public void update(PlantillaArquetipo arquetipo) {
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(arquetipo);
     
        session.getTransaction().commit();
        session.close();
        
    }  
    
 // Codigo para modificar un alumnos en la BD
    public double getLast() {
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        
        double query = session.createQuery("select max(idInterno) from PlantillaArquetipo", Double.class).getSingleResult();
     
        session.getTransaction().commit();
        session.close();
        
        return query+1;
    }  
}
