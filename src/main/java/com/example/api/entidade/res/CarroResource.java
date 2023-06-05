package com.example.api.entidade.res;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entidade.Carro;
import com.example.api.entidade.Pessoa;
import com.example.api.entidade.repositorio.CarroRepositorio;
import com.example.api.entidade.repositorio.PessoaRepositorio;
import com.example.api.entidade.servico.CarroServico;


@RestController
@RequestMapping(value="/carros")
public class CarroResource {
	
	@Autowired
	private CarroServico service;
	
	@Autowired
	private PessoaRepositorio pr;
	
	@Autowired
	private CarroRepositorio cr;
	
  
	@GetMapping	
	public ResponseEntity<List<Carro>> findAll(){
		List<Carro> list=service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping("/{pessoaId}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Carro> insert(@RequestBody Carro obj, @PathVariable("pessoaId") Long pessoaId) {
	    Pessoa p = pr.findById(pessoaId).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
	    p.getCarros().add(obj);
	    obj.setDono(p);
	    obj = service.inserir(obj);
	    return ResponseEntity.ok().body(obj);
	}
	
	
	@DeleteMapping(value="/{id}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> Delete(@PathVariable long id){
		service.Delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value="/{id}")	
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Carro> update(@PathVariable long id,@RequestBody Carro obj){
		 obj=service.Update(id, obj);
		 return ResponseEntity.ok().body(obj);
	}
	
	


}
