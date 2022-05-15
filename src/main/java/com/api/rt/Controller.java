package com.api.rt;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/alunos")
public class Controller<ALunos> {
	
     @Autowired	
     private AlunosRepository repository;

	// VER SE ESTAR ONLINE
	@GetMapping("Online")
	public String online() {
		return "SUA API ESTÁ ONLINE";
		
	} 
    //LISTAR E CADASTRAR ALUNOS 
	@GetMapping("Listar")
	public List<Alunos>  listarAlunos(){
	 return repository.findAll();
	}
	
	// ADICIONAR ALUNOS CADASTRADOS 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alunos adicionar(@RequestBody Alunos Alunos) {
	  return repository.save(Alunos);
    }
    
   // SELECIONAR PELO ID 
     @GetMapping("api/{id}")  
	public Alunos SelecinonarPeloId(@PathVariable Long id) {
		return repository.findByid(id);
	 }
      
     
     //ATUALIZAR DADOS SALVOS
     @PutMapping("/api")
     public Alunos editar(@RequestBody Alunos Obj) {
    	 return repository.save(Obj); 
    	 
     }
     
     //DELETAR ALUNOS
     @DeleteMapping("/deletar/{id}")
     public void remover(@PathVariable Long id) {
    	 Alunos obj = SelecinonarPeloId(id);
    	 repository.delete(obj);
     }
     
     // VER QUANTIDADES DE REGISTROS
     @GetMapping("/contador")
     public long  contador () {
    	 return repository.count();
    	 
     }
     //ORDENAR LISTA COM NOMES
     @GetMapping ("/ordenar/nome")
     public List<Alunos> OrdenarPnomes(){
    	return repository.findByOrderByNome();
    	
     }
     // FILTRAR NOMES UNICOS
     @GetMapping("/ordenar/filtrar")
     public List<Alunos> OrdenarFiltar(){
    return repository.findByNomeOrderByEscolaDesc("Janaina");
    	
     }
     // FILTRAR POR LETRA ESPECIFICA
     @GetMapping("/ordenar/letra")
     public List<Alunos> nomeContem(){
    	 return repository.findByNomeContaining("J");
     }

     //procura o dadoNome que inicia 
     @GetMapping("/inicia/letra")
     public List <Alunos> iniciaCom(){
    	 return repository.findByNomeStartsWith("a");
     }

     //procura o dadoNome que termina
     @GetMapping("/termina/letra")
     public List <Alunos> terminaCom(){
    	return repository.findByNomeEndsWith("a");
     }
     //SOMA AS IDADES DO BANCO
     @GetMapping("/api/somaIdades")
     public int SomaIdades(){
        return repository.somaIdades();
     }
     //FILTAR IDADES >= A IDADE
     @GetMapping("/api/idades/IgualMaior")
     public List<Alunos> idadesMaiorIgual(){
        return  repository.idadesMaiorIgual(20);

     }
     //FILTRAR IDADE UNICA
     @GetMapping("/api/idades/unica")
     public List<Alunos> idadesFixa(){
       return repository.idadeAtual(18);
     }

     //Tratamento De Status
     @GetMapping("/status")
     public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
     }

}
