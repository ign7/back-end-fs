package com.example.api.entidade.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entidade.Carro;


public interface CarroRepositorio  extends JpaRepository<Carro,Long> {

}