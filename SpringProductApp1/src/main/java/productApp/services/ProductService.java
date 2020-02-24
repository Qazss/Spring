package productApp.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import productApp.entities.Client;
import productApp.entities.Product;


@Component
public class ProductService {
	private SessionFactory factory = new Configuration()
			.configure("resourses/hibernate.cfg.xml")
			.addAnnotatedClass(Client.class)
			.addAnnotatedClass(Product.class)
			.buildSessionFactory();

	public void saveProduct(Product product){
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

	public void removeProductById(int id){
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Product product = session.get(Product.class, id);
			session.delete(product);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}
}
