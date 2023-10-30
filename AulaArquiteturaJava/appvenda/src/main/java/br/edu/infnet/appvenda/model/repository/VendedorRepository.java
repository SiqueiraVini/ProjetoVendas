package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.appvenda.model.domain.Vendedor;

public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

}
