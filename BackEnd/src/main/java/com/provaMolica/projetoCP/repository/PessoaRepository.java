package com.provaMolica.projetoCP.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.provaMolica.projetoCP.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	@Query(value = "SELECT o FROM Pessoa o WHERE "
			+ " :nome is null or UPPER(o.nome) like upper(:nome)")
	Page<Pessoa> findByAll(String nome, Pageable pageable);

}
