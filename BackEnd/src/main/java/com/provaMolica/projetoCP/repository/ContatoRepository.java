package com.provaMolica.projetoCP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.provaMolica.projetoCP.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Integer>{

}
