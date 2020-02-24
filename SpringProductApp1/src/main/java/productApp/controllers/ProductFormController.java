package productApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import productApp.entities.Product;
import productApp.services.ClientService;
import productApp.services.ProductService;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Product product) {
		productService.saveProduct(product);
		return "product_form";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String deleteNumberValue = request.getParameter("deleteNumber");
		int deleteNumber = Integer.parseInt(deleteNumberValue);
		System.out.println(deleteNumber);
		productService.removeProductById(deleteNumber);
		return "product_form";
	}
}
