package productApp.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import productApp.entities.Product;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query(value = "Select id, name, cost from products where cost = (select max(cost) from products)", nativeQuery = true)
	Product findProductByMaxCost();

	@Query(value = "Select id, name, cost from products where cost = (select min(cost) from products)", nativeQuery = true)
	Product findProductByMinCost();

	List<Product> findAllByCostBetween(double min, double max);

	List<Product> findAllByCostGreaterThan(double min);

	List<Product> findAllByCostLessThan(double max);

}
