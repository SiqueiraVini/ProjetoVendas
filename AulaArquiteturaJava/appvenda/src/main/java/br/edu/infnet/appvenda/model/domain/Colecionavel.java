package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TColecionavel")
public class Colecionavel extends Produto {
	@Size(min = 2, max = 50, message = "O fornecedor deve ter entre {min} e {max} caracteres")
	private String fornecedor;
	@Size(min = 2, max = 50, message = "O material deve ter entre {min} e {max} caracteres")
	private String material;
	private boolean autenticado;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(),fornecedor, material, autenticado);
	}
	
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

}
