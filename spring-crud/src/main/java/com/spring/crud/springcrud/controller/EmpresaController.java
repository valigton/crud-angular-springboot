package com.spring.crud.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.springcrud.model.Empresa;
import com.spring.crud.springcrud.repository.EmpresaRepository;

@RestController
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping("/empresas")
	public List<Empresa> read() {
		return empresaRepository.findAll();
	}
	
	@PostMapping("/empresas")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa create(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	@PutMapping("/empresas/{id}")
	public Empresa update(@RequestBody Empresa novaEmpresa, @PathVariable Long id) {
		return empresaRepository.findById(id)
				.map(empresa -> {
					empresa.setNome(novaEmpresa.getNome());
					return empresaRepository.save(empresa);
				})
				.orElseGet(() -> {
					novaEmpresa.setId(id);
					return empresaRepository.save(novaEmpresa);
				});
	}
	
	@DeleteMapping("/empresas/{id}")
	public void delete(@PathVariable Long id) {
		empresaRepository.deleteById(id);
	}
}
