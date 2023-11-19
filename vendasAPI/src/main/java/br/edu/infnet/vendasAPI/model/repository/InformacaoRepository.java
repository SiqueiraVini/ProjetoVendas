package br.edu.infnet.vendasAPI.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.vendasAPI.model.domain.Informacao;

@Repository
public interface InformacaoRepository extends CrudRepository<Informacao, Integer> {

}