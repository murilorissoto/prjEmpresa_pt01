package com.senai.PrjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.PrjEmpresa.entities.*;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
