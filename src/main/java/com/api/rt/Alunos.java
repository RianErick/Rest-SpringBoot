package com.api.rt;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alunos {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column (nullable = false)
	private Long id;
    
	@Column 
	private String nome;
	
	@Column 
	private String cpf;

	public int getIdades() {
		return idades;
	}

	public void setIdades(int idades) {
		this.idades = idades;
	}

	@Column
	private String rg;

	@Column
	private int idades;

	@Column 
    private String escola;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEscola() {
		return escola;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, escola, id, nome, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alunos other = (Alunos) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(escola, other.escola) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(rg, other.rg);
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}
}
