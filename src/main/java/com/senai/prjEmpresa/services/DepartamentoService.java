package com.senai.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.prjEmpresa.entities.Departamento;
import com.senai.prjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentoRepository;	
	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository ) {
		this.departamentoRepository = departamentoRepository;
	}
		public Departamento SaveDepartamento(Departamento Departamento) {
			return departamentoRepository.save(Departamento);
		}
		public List<Departamento> getAllDepartamento(){
			return departamentoRepository.findAll();
		}
		
		public Departamento getDepartamentoByid(Long depcodigo) {
			return departamentoRepository.findById(depcodigo).orElse(null);			
		}
		
		public void deleteDepartamento(Long depcodigo) {
			departamentoRepository.deleteById(depcodigo);
		}
		
		// fazendo o update do nome do funcionario com o optional
			public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
		        Optional<Departamento> DepartamentoOptional = departamentoRepository.findById(depcodigo);
		        if (DepartamentoOptional.isPresent()) {
		        	Departamento DepartamentoExistente = DepartamentoOptional.get();
		         	DepartamentoExistente.setDepnome(novoDepartamento.getDepnome());
		            return departamentoRepository.save(DepartamentoExistente); 
		        } else {
		            return null; 
		        }
		 
	}
}
