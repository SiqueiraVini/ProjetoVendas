package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Colecionavel;

@Service
public class ColecionavelService {

	private Map<Integer, Colecionavel> mapaColecionavel = new HashMap<Integer, Colecionavel>();
	
	public void incluir (Colecionavel colecionavel) {
		mapaColecionavel.put(colecionavel.getCodigo(), colecionavel);
	}

	public Collection<Colecionavel> obterLista(){
		return mapaColecionavel.values();
	}
	
}