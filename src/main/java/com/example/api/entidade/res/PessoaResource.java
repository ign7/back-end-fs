package com.example.api.entidade.res;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.api.entidade.Pessoa;
import com.example.api.entidade.servico.PessoaServico;




@RestController
@RequestMapping(value="/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaServico service;
  
	@GetMapping
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list=service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	@CrossOrigin("http://localhost:3000")
	public  ResponseEntity<Pessoa> findById(@PathVariable Long id){		
		Pessoa usuario=service.findbyId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj){
		obj=service.insert(obj);
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	@DeleteMapping(value="/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> Delete(@PathVariable long id){
		service.Delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value="/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Pessoa> update(@PathVariable long id,@RequestBody Pessoa obj){
		 obj=service.Update(id, obj);
		 return ResponseEntity.ok().body(obj);
	}

}
