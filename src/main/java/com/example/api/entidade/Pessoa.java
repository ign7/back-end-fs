package com.example.api.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Pessoa  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private Integer idade;
	private String cnh;
	
	
	@OneToMany(mappedBy="dono")
	private List<Carro> carros = new ArrayList<>();
	
	
	public Pessoa() {
		
	}
	

	public Pessoa(long id, String nome, Integer idade, String cnh) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cnh = cnh;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public String getCNH() {
		return cnh;
	}


	public void setCNH(String cnh) {
		this.cnh=cnh;
	}
	

	public List<Carro> getCarros() {
		return carros;
	}


	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return id == other.id;
	}
	
	
	
	
	

}
