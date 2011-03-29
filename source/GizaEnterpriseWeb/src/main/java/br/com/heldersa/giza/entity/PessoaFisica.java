/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.heldersa.giza.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "pessoa_fisica", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rg_id"}),
    @UniqueConstraint(columnNames = {"cpf"})})
@DiscriminatorValue(value="PF")
public class PessoaFisica extends Pessoa {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Basic(optional = false)
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "filiacao_pai", length = 255)
    private String filiacaoPai;

    @Column(name = "filiacao_mae", length = 255)
    private String filiacaoMae;

    @Basic(optional = false)
    @Column(name = "sexo", nullable = false, length = 255)
    private String sexo;

    @JoinColumn(name = "naturalidade_id", referencedColumnName = "id")
    @ManyToOne
    private Municipio naturalidade;

    @JoinColumn(name = "estado_civil_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivil;

    @JoinColumn(name = "rg_id", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Rg rg;

    public PessoaFisica() {
    }

    public PessoaFisica(Long id) {
        this.id = id;
    }

    public PessoaFisica(Long id, String nome, String cpf, String sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFiliacaoPai() {
        return filiacaoPai;
    }

    public void setFiliacaoPai(String filiacaoPai) {
        this.filiacaoPai = filiacaoPai;
    }

    public String getFiliacaoMae() {
        return filiacaoMae;
    }

    public void setFiliacaoMae(String filiacaoMae) {
        this.filiacaoMae = filiacaoMae;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Municipio getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Municipio naturalidade) {
        this.naturalidade = naturalidade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Rg getRg() {
        return rg;
    }

    public void setRg(Rg rg) {
        this.rg = rg;
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
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
