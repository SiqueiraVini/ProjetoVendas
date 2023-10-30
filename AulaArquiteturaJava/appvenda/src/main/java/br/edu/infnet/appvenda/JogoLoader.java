package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Jogo;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.JogoService;

@Order(3)
@Component
public class JogoLoader implements ApplicationRunner {
	
	@Autowired
	private JogoService jogoService;

		
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("Files/jogo.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Jogo jogo = new Jogo();
			
			jogo.setDescricao(campos[0]);
			jogo.setCodigo(Integer.valueOf(campos[1]));
			jogo.setPreco(Float.valueOf(campos[2]));
			jogo.setEstoque(Boolean.valueOf(campos[3]));
			jogo.setProdutora(campos[4]);
			jogo.setDiretor(campos[5]);
			jogo.setDigital(Boolean.valueOf(campos[6]));
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[7]));
			
			jogo.setVendedor(vendedor);
			
			jogoService.incluir(jogo);
									
			linha = leitura.readLine();
		}

		for(Jogo jogo: jogoService.obterLista()) {
			System.out.println("[Jogo] " + jogo);			
		}
		
		leitura.close();
	}


	
}