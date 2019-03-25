package br.edu.unoesc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

public class Concurso {

	private ObjectId id;
	private Long numero;
	private Date data;
	private List<Integer> numeros;
	private List<Ganhador> ganhadores;
	
	// valida se ganhou 
	public boolean validador(List<Integer> palpites, Ganhador ganhador) {
		Integer acertos = 0;
		for(Integer n: numeros) {
			for(Integer p: palpites) {
				if(n == p) {
					acertos++;
				}
			}
		}
		if(acertos >=5) {
			ganhador.setQtd_acertos(acertos);
			addGanhador(ganhador);
			return true;
		}
		return false;	
	}
	
	// adiciona numeros
	public void adicionarNumeros(Integer v1,Integer v2,Integer v3,Integer v4,Integer v5,Integer v6) {
		numeros = new ArrayList<Integer>();
		numeros.add(v1);
		numeros.add(v2);
		numeros.add(v3);
		numeros.add(v4);
		numeros.add(v5);
		numeros.add(v6);	
	}
	
	// adiciona ganhador, tratando nullPointer
	private void addGanhador(Ganhador ganhador) {
		if(ganhadores == null) {
			ganhadores = new ArrayList<Ganhador>();
		}
		this.ganhadores.add(ganhador);			
	}

	
	
	
	public Concurso() {
		
	}

	public Concurso(ObjectId id, Long numero, Date data, ArrayList<Integer> numeros, List<Ganhador> ganhadores) {
		super();
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.setNumeros(numeros);
		this.ganhadores = ganhadores;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Ganhador> getGanhadores() {
		return ganhadores;
	}

	public void setGanhadores(List<Ganhador> ganhadores) {
		this.ganhadores = ganhadores;
	}

	public List<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Integer> numeros) {
		this.numeros = numeros;
	}	
}
