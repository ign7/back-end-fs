package com.example.api.entidade.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.api.entidade.Carro;
import com.example.api.entidade.repositorio.CarroRepositorio;
import com.example.api.entidade.repositorio.PessoaRepositorio;




@Service
public class CarroServico  {

	@Autowired
	CarroRepositorio repositorio;
	@Autowired
    private PessoaRepositorio PessoaRepositorio;
	
	public List<Carro> findAll(){
		return repositorio.findAll();
	}

	
    public Carro inserir(Carro obj) {
        return repositorio.save(obj);
    }
    
    public void Delete(long id) {
		try {
		repositorio.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();		}
	}
	
	
	public Carro Update(long id,Carro obj) {
		Carro entity = repositorio.getReferenceById(id);
		UpdateData(entity,obj);
		return repositorio.save(entity);
	}
	
	private void UpdateData(Carro entity,Carro obj) {
		entity.setNome(obj.getNome());
		entity.setMarca(obj.getMarca());
		entity.setAno(obj.getAno());
	}
	
}
