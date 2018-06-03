package juno.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Employee employee = new Employee();
    	employee.setName("Prakash");
    	
        SessionFactory sessionFactory = buildSessionFactory();
        System.out.println("created");
        Session session = sessionFactory.openSession();
        session.save(employee);
        session.close();
        sessionFactory.close();
        
    }
    
    private static SessionFactory buildSessionFactory() {
    	return new Configuration().configure("/juno/Hibernate/resources/hibernate.cfg.xml").buildSessionFactory();
    }
    
}
