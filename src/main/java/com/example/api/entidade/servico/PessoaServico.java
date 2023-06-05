package com.example.api.entidade.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.entidade.Pessoa;
import com.example.api.entidade.repositorio.PessoaRepositorio;





@Service
public class PessoaServico  {

	@Autowired
	PessoaRepositorio repositorio;
	
	public List<Pessoa> findAll(){
		return repositorio.findAll();
	}
	
	public Pessoa findbyId(Long id) {
		 Optional <Pessoa> obj = repositorio.findById(id);
		 return obj.get();
	}
	
	public Pessoa insert(Pessoa obj) {
		 return repositorio.save(obj);
	}
	
	public void Delete(long id) {
		try {
		repositorio.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();;
		}
	}
	
	public Pessoa Update(long id,Pessoa obj) {
		Pessoa entity = repositorio.getReferenceById(id);
		UpdateData(entity,obj);
		return repositorio.save(entity);
	}
	
	private void UpdateData(Pessoa entity,Pessoa obj) {
		entity.setNome(obj.getNome());
		entity.setIdade(obj.getIdade());
		entity.setCNH(obj.getCNH());
	}
}
