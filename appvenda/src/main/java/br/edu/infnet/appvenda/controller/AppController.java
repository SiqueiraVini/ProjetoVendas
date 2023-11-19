package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.ColecionavelService;
import br.edu.infnet.appvenda.model.service.JogoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ColecionavelService colecionavelService;
	@Autowired
	private JogoService jogoService;

	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeColecionavel", colecionavelService.obterQtde());
		model.addAttribute("qtdeJogo", jogoService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		
		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("listagem", produtoService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/colecionavel/lista")
	public String obterListaColecionavel(Model model) {
		
		model.addAttribute("titulo", "Produtos Colecionaveis:");
		model.addAttribute("listagem", colecionavelService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/jogo/lista")
	public String obterListaJogo(Model model) {
		
		model.addAttribute("titulo", "Produtos Jogos:");
		model.addAttribute("listagem", jogoService.obterLista());

		return showHome(model);
	}
}