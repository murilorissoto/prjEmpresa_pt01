package com.senai.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.PrjEmpresa.entities.*;
import com.senai.PrjEmpresa.services.*;

@RestController
@RequestMapping("/departamento")
public class FuncionarioControler {
	
	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioControler(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; 
	}

	@GetMapping("/(id)")
	public ResponseEntity<Funcionario> getfuncionario(@PathVariable Long funcodigo) {
		Funcionario funcionario = funcionarioService.getFuncionarioById(funcodigo);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}

	@GetMapping("/{id}")
	public Funcionario getFuncionario(@PathVariable Long funcodigo) {
		return funcionarioService.getFuncionarioById(funcodigo);
	}
	
	public List<Funcionario> getAllFuncionario() {
		return funcionarioService.getAllFuncionario();
	}

	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long id) {
		funcionarioService.deleteFuncionario(id);
	}

		@GetMapping
		public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Funcionario> funcionario = funcionarioService.getAllFuncionario();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(funcionario);
		}
		
		@PutMapping("/{id}")
		public Funcionario updateFuncionario(@PathVariable Long funcodigo, @RequestBody Funcionario funcionario) {
		    return funcionarioService.updateFuncionario(funcodigo, funcionario);
		}
}