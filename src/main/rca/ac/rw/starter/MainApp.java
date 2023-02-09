package rca.ac.rw.starter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rca.ac.rw.orm.Customer;

public class MainApp {
    public static void main (String[] args){
        Customer customer1 = new Customer("Patrick", "NDAYAMBAJE");
        Customer customer2 = new Customer("Jazzy", "Bruno");

        System.out.println("-------Configuration started--------");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        System.out.println("-------Configuration ended--------");

        System.out.println("-------Session started--------");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        System.out.println("-------Transaction started--------");

        Transaction transaction = session.beginTransaction();
        session.save(customer1);
        session.save(customer2);
        session.delete(customer2);
        transaction.commit();

        System.out.println("-------Transaction ended--------");

        session.close();

        System.out.println("-------Session closed--------");

    }
}
