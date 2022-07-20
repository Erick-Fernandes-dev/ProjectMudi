package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		Sort sort = Sort.by("dataDaEntrega").descending();
//		.descending() --> ordem decrescente
//		.ascending() --> ordem crescente
		//		                               A   B    C
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		// A -> item | B -> pagina | C -> por ordem crescente OU decrescente
		
		//vai listar pedidos por status, 1 item para cada x paginas que pode ser em ordem crescente ou decrescente
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
//	@GetMapping("/{status}")
//	public String porStatus(@PathVariable("status") String status, Model model) {
//		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
//		model.addAttribute("pedidos", pedidos);
//		model.addAttribute("status", status);
//		return "home";
//	}
//	
//	@ExceptionHandler(IllegalArgumentException.class)
//	public String onError() {
//		return "redirect:/home";
//	}
	
	
	
}
