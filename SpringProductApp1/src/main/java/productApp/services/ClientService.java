package productApp.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import productApp.entities.Client;
import productApp.entities.Product;

import java.util.List;


@Component
public class ClientService {
	private SessionFactory factory = new Configuration()
			.configure("resourses/hibernate.cfg.xml")
			.addAnnotatedClass(Client.class)
			.addAnnotatedClass(Product.class)
			.buildSessionFactory();


	public void saveClient(Client client){
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

	public void removeClientById(int id){
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Client client = session.get(Client.class, id);
			session.delete(client);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

	public List<Client> getAllClients(){
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Client> allClients = session.createQuery("from Client").getResultList();
			session.getTransaction().commit();
			return allClients;
		} finally {
			session.close();
			factory.close();
		}
	}
}
