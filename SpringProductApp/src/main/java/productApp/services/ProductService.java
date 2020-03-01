package productApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import productApp.entities.Product;
import productApp.repositories.ProductsRepository;

import java.util.List;

@Component
public class ProductService {
	private ProductsRepository repository;

	@Autowired
	public void setRepository(ProductsRepository repository) {
		this.repository = repository;
	}

	public Product getProductById(long id) {
		return repository.getProductById(id);
	}

	public void addProduct(Product product) {
		repository.addProduct(product);
	}

	public List<Product> getAllProducts() {
		return repository.getAllProducts();
	}

	public void showAll(){
		repository.showAllProducts();
	}
}
