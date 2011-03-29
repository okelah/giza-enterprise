/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.heldersa.giza.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 *
 * @author Administrador
 */
@MappedSuperclass
public class Pessoa extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 2)
    private String tipo;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private PessoaFisica pessoaFisica;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private PessoaJuridica pessoaJuridica;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaId")
    private Cliente cliente;

    public Pessoa() {
    }

    public Pessoa(Long id) {
        this.id = id;
    }

    public Pessoa(Long id, boolean ativo, String tipo) {
        this.id = id;
        this.ativo = ativo;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
