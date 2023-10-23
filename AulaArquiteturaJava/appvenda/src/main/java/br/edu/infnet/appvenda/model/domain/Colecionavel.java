package br.edu.infnet.appvenda.model.domain;

public class Colecionavel extends Produto {
	private String fornecedor;
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
