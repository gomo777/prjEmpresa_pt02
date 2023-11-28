package com.senai.prjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.prjEmpresa.entities.Departamento;
import com.senai.prjEmpresa.entities.Funcionario;
import com.senai.prjEmpresa.services.DepartamentoService;

@RestController
@RequestMapping("/Departamento")
public class DepartamentoControler {
	private final DepartamentoService DepartamentoService;

	@Autowired
	public DepartamentoControler(DepartamentoService DepartamentoService) {
		this.DepartamentoService = DepartamentoService;
	}

	@PostMapping
	public Departamento createProduct(@RequestBody Departamento Departamento) {
		// return produtoService.saveProduto(produto);
		return DepartamentoService.SaveDepartamento(Departamento);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long depcodigo) {
		Departamento Departamento = DepartamentoService.getDepartamentoByid(depcodigo);
		if (Departamento != null) {
			return ResponseEntity.ok(Departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // nome do seu arquivo HTML , (sem a extensão)
	}

	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long depcodigo) {
		DepartamentoService.deleteDepartamento(depcodigo);
	}

	
	@GetMapping("/")
	public ResponseEntity<List<Departamento>> getAllDepartamento() {
		List<Departamento> novodepartamento = DepartamentoService.getAllDepartamento();
		return ResponseEntity.ok(novodepartamento);
	}

	@PutMapping("/{id}")
	public Departamento updateDepartamento(@PathVariable Long depcodigo, @RequestBody Departamento Departamento) {
		return DepartamentoService.getDepartamentoByid(depcodigo);
	}
}
