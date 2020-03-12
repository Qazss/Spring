package productApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productApp.entities.Product;
import productApp.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product getProductWithMaxCost() {
		return productRepository.findProductByMaxCost();
	}

	public Product getProductWithMinCost() {
		return productRepository.findProductByMinCost();
	}

	public List<Product> getProductsWithCostBetween(double minCost, double maxCost) {
		return productRepository.findAllByCostBetween(minCost, maxCost);
	}

	public List<Product> getProductsWithCostLessThan (double value) {
		return productRepository.findAllByCostLessThan(value);
	}

	public List<Product> getProductsWithCostGreaterThan (double value) {
		return productRepository.findAllByCostGreaterThan(value);
	}
}
