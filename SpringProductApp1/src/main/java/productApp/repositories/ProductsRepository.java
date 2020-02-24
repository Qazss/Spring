package productApp.repositories;


import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import productApp.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {
	private List<Product> repository = new ArrayList<>();
	private int productID = 0;

	public Product getProductById(long id) {
		if (!CollectionUtils.isEmpty(repository)) {
			for (Product product: repository) {
				if (product.getId() == id) {
					return product;
				}
			}
		}
		return new Product();
	}

	public List<Product> getAllProducts() {
		return repository;
	}

	public void addProduct(Product product) {
		product.setId(productID++);
		repository.add(product);
	}

	public void showAllProducts(){
		if (!CollectionUtils.isEmpty(repository)) {
			for (Product product: repository) {
				System.out.println(product.getTitle() + " " + product.getCost());
			}
 		}
	}
}
