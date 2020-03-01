package productApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import productApp.entities.Product;
import productApp.services.ProductService;

import java.util.List;


@Controller
@RequestMapping("/product")
public class AllProductsController {
	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/showAllProducts")
	public String showAllProducts(Model uiModel){
		List<Product> products = productService.getAllProducts();
		uiModel.addAttribute("products", products);

		return "all_products";
	}
}
