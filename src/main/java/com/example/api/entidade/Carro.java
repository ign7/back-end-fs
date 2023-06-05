package com.example.api.entidade;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String marca;
    private Integer ano;
    
    
  
  
  	@JsonIgnore
	@ManyToOne	
	@JoinColumn(name="dono_id")
	private Pessoa dono;
  
	public Carro() {
		  
	}


	public Carro(long id, String nome, String marca, Integer ano, Pessoa dono) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.ano = ano;
		this.dono=dono;
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


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	


	public Pessoa getDono() {
		return dono;
	}


	public void setDono(Pessoa dono) {
		this.dono = dono;
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
		Carro other = (Carro) obj;
		return id == other.id;
	}
	
	
  
  

}
