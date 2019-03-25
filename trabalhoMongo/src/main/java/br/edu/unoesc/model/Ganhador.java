package br.edu.unoesc.model;

public class Ganhador {
	
	private String nome;
	private Integer qtd_acertos;
	
	public Ganhador() {
	
	}
	
	public Ganhador(String nome, Integer qtd_acertos) {
		this.nome = nome;
		this.qtd_acertos = qtd_acertos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQtd_acertos() {
		return qtd_acertos;
	}
	public void setQtd_acertos(Integer qtd_acertos) {
		this.qtd_acertos = qtd_acertos;
	}
	
	

}
