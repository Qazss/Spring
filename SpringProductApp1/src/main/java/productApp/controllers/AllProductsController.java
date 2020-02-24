package productApp.controllers;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import productApp.entities.Client;
import productApp.entities.Product;
import productApp.services.ClientService;
import productApp.services.ProductService;

import java.util.List;


@Controller
@RequestMapping("/product")
public class AllProductsController {
	private ClientService clientService;

	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("/showProducts")
	public String showAllProducts(Model uiModel){
		List<Client> clients = clientService.getAllClients();
		uiModel.addAttribute("clients", clients);

		return "all_products";
	}
}
