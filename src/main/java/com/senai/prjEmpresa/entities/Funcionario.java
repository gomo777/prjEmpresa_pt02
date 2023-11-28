package com.senai.prjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
	// depcodigo , depnome
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;

	private String funnome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funnascimento;

	private Double funsalario;

	@ManyToOne
	private Departamento departamento;

	// método de acesso
	public Long getfuncodigo() {
		return funcodigo;
	}

	public void setfuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}

	// método de acesso
	public String getfunnome() {
		return funnome;
	}

	public void setfunnome(String funnome) {
		this.funnome = funnome;
	}

	// método de acesso
	public LocalDate getfunnascimento() {
		return funnascimento;
	}

	public void setfunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}

	public Double getfunsalario() {
		return funsalario;
	}

	public void setfunsalario(Double funsalario) {
		this.funsalario = funsalario;
	}

	// inserir os metodos get e o set
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
