package productApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import productApp.entities.Product;
import productApp.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductFormController {
	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showProductFillForm(Model uiModel) {
		System.out.println("Отработал GET запрос");
		Product product = new Product();
		uiModel.addAttribute(product);
		return "product_form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String create(Product product) {
		System.out.println("Отработал Post запрос");
		System.out.println("Product: " + product.getTitle() + " " + product.getCost());
		productService.addProduct(product);
		productService.showAll();
		return "product_form";
	}

}
