package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Colecionavel;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ColecionavelService;

@Order(4)
@Component
public class ColecionavelLoader implements ApplicationRunner {
	
	@Autowired
	private ColecionavelService colecionavelService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("Files/colecionavel.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Colecionavel colecionavel = new Colecionavel();
			
			colecionavel.setDescricao(campos[0]);
			colecionavel.setCodigo(Integer.valueOf(campos[1]));
			colecionavel.setPreco(Float.valueOf(campos[2]));
			colecionavel.setEstoque(Boolean.valueOf(campos[3]));
			colecionavel.setFornecedor(campos[4]);
			colecionavel.setMaterial(campos[5]);
			colecionavel.setAutenticado(Boolean.valueOf(campos[6]));
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[7]));
			
			colecionavel.setVendedor(vendedor);
						
			colecionavelService.incluir(colecionavel);
			
			linha = leitura.readLine();
		}

		for(Colecionavel colecionavel: colecionavelService.obterLista()) {
			System.out.println("[Colecionavel] " + colecionavel);			
		}
		
		leitura.close();
	}


}
