package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Colecionavel;
import br.edu.infnet.appvenda.model.domain.Jogo;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

		
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("Files/produto.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			switch(campos[7]) {
			case "J":
				Jogo jogo = new Jogo();
				
				jogo.setDescricao(campos[0]);
				jogo.setCodigo(Integer.valueOf(campos[1]));
				jogo.setPreco(Float.valueOf(campos[2]));
				jogo.setEstoque(Boolean.valueOf(campos[3]));
				jogo.setProdutora(campos[4]);
				jogo.setDiretor(campos[5]);
				jogo.setDigital(Boolean.valueOf(campos[6]));
				
				produtoService.incluir(jogo);
				
				break;
			case "C":
				Colecionavel colecionavel = new Colecionavel();
				
				colecionavel.setDescricao(campos[0]);
				colecionavel.setCodigo(Integer.valueOf(campos[1]));
				colecionavel.setPreco(Float.valueOf(campos[2]));
				colecionavel.setEstoque(Boolean.valueOf(campos[3]));
				colecionavel.setFornecedor(campos[4]);
				colecionavel.setMaterial(campos[5]);
				colecionavel.setAutenticado(Boolean.valueOf(campos[6]));
				
				produtoService.incluir(colecionavel);
				
				break;
			default:
				break;
			}
			
			linha = leitura.readLine();
		}

		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
		leitura.close();
	}
}

	

