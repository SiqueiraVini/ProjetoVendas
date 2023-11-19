package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Colecionavel;
import br.edu.infnet.appvenda.model.repository.ColecionavelRepository;

@Service
public class ColecionavelService {

	@Autowired
	private ColecionavelRepository colecionavelRepository;
	
	public void incluir (Colecionavel colecionavel) {
		colecionavelRepository.save(colecionavel);
	}

	public Collection<Colecionavel> obterLista(){
		return (Collection<Colecionavel>) colecionavelRepository.findAll();
	}
	
	public long obterQtde() {
		return colecionavelRepository.count();
	}
	
	
}