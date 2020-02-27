package productApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import productApp.entities.Product;
import productApp.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static final String MAX = "max";
	private static final String MIN = "min";

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/showminmax/{value}", method = RequestMethod.GET)
	public String showProductWithMaxCost(Model uiModel, @PathVariable(value = "value") String value){
		List<Product> resultList = new ArrayList<>();
		Product product = null;

		if (value.equals(MAX)) {
			product = productService.getProductWithMaxCost();
		} else if (value.equals(MIN)) {
			product = productService.getProductWithMinCost();
		} else {
			throw new IllegalArgumentException();
		}

		resultList.add(product);
		uiModel.addAttribute("products", resultList);
		return "products";
	}

	@RequestMapping(value = "/showbetween")
	public String showProductsBetweenValues(Model uiModel, @RequestParam(name = "min") double min, @RequestParam(name = "max") double max) {
		List<Product> resultList = productService.getProductsWithCostBetween(min, max);
		uiModel.addAttribute("products", resultList);
		return "products";
	}

	@RequestMapping(value = "/showless")
	public String showProductsLessThanValue(Model uiModel, @RequestParam(name = "value") double value) {
		List<Product> resultList = productService.getProductsWithCostLessThan(value);
		uiModel.addAttribute("products", resultList);
		return "products";
	}

	@RequestMapping(value = "/showgreater")
	public String showProductsGreaterThanValue(Model uiModel, @RequestParam(name = "value") double value) {
		List<Product> resultList = productService.getProductsWithCostGreaterThan(value);
		uiModel.addAttribute("products", resultList);
		return "products";
	}
}
