package com.example.api.entidade.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entidade.Pessoa;


public interface PessoaRepositorio  extends JpaRepository<Pessoa,Long> {

}