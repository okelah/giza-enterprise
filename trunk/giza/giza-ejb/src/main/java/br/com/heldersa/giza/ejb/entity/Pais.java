package br.com.heldersa.giza.ejb.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name = "pais", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
public class Pais extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "sigla", length = 3)
	private String sigla;

	public Pais() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}