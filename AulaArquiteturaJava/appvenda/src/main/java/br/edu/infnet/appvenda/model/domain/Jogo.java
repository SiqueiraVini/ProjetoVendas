package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TJogo")
public class Jogo extends Produto {
	private String produtora;
	private String diretor;
	private boolean digital;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(),produtora, diretor, digital);
	}
	
	public String getProdutora() {
		return produtora;
	}
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public boolean isDigital() {
		return digital;
	}
	public void setDigital(boolean digital) {
		this.digital = digital;
	}	
}
