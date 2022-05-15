package com.api.rt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {
    
	
	
	Alunos findByid(Long id) ;
	
	
    List<Alunos> findByOrderByNome();
    //Ask  //ORDENAR DE A-Z
    //Desc // DO MENOR PARA O MAIOR
    
    
    //Ordenar Por Um Unico Nome
    List<Alunos> findByNomeOrderByEscolaDesc(String nome);
    
    
    
    // Ordenar por Letras Especificas
    List<Alunos> findByNomeContaining(String termo);



    //procura o dadoNome que inicia
    List<Alunos> findByNomeStartsWith(String termo);



    //procura o dadoNome que termina
    List<Alunos> findByNomeEndsWith(String termo);


    // Criando Propria Query
    // Somar Idades
    @Query(value = "SELECT SUM( idades) FROM alunos" , nativeQuery = true)
    int somaIdades();

    //Ver Idades MaiorOuIgual
    @Query(value = "SELECT * FROM alunos WHERE idades >= :idades" , nativeQuery = true)
    List<Alunos> idadesMaiorIgual(int idades);


    //Ver Unica Idade
    @Query(value = "SELECT * FROM alunos WHERE idades = :idades" , nativeQuery = true)
    List<Alunos> idadeAtual(int idades);
 }
