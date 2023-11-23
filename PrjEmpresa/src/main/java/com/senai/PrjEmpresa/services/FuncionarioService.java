package com.senai.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.PrjEmpresa.entities.*;
import com.senai.PrjEmpresa.repositories.*;

@Service
public class FuncionarioService {

private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService( FuncionarioRepository FuncionarioRepository) {
		this.funcionarioRepository = FuncionarioRepository;
	}
	
	public Funcionario saveFuncionario (Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario getFuncionarioBy (Long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public void deleteFuncionario (Long funcodigo) {
		funcionarioRepository.deleteById(funcodigo);
	}
		
		public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
			Optional<Funcionario> FuncionarioOptional = funcionarioRepository.findById(funcodigo);
			if (FuncionarioOptional.isPresent()) {
				Funcionario FuncionarioExistente = FuncionarioOptional.get();
					FuncionarioExistente.setfunnome(novoFuncionario.getnome());
				FuncionarioExistente.setfunnome(novoFuncionario.getnome());
					return funcionarioRepository.save(FuncionarioExistente);
			}else{
				return null;
			}
	}

		public Funcionario getFuncionarioById(Long funcodigo) {
			// TODO Auto-generated method stub
			return null;
		}

}
