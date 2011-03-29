/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.heldersa.giza.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "endereco")
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findById", query = "SELECT e FROM Endereco e WHERE e.id = :id"),
    @NamedQuery(name = "Endereco.findByAtivo", query = "SELECT e FROM Endereco e WHERE e.ativo = :ativo"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByComplemento", query = "SELECT e FROM Endereco e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Basic(optional = false)
    @Column(name = "logradouro", nullable = false, length = 255)
    private String logradouro;

    @Column(name = "complemento", length = 255)
    private String complemento;

    @Column(name = "bairro", length = 255)
    private String bairro;

    @Column(name = "cep", length = 10)
    private String cep;

    @JoinColumn(name = "municipio_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Municipio municipioId;

    @JoinColumn(name = "tipo_logradouro_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoLogradouro tipoLogradouroId;

    @JoinColumn(name = "tipo_endereco_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoEndereco tipoEnderecoId;

    public Endereco() {
    }

    public Endereco(Long id) {
        this.id = id;
    }

    public Endereco(Long id, boolean ativo, String logradouro) {
        this.id = id;
        this.ativo = ativo;
        this.logradouro = logradouro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public TipoLogradouro getTipoLogradouroId() {
        return tipoLogradouroId;
    }

    public void setTipoLogradouroId(TipoLogradouro tipoLogradouroId) {
        this.tipoLogradouroId = tipoLogradouroId;
    }

    public TipoEndereco getTipoEnderecoId() {
        return tipoEnderecoId;
    }

    public void setTipoEnderecoId(TipoEndereco tipoEnderecoId) {
        this.tipoEnderecoId = tipoEnderecoId;
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.heldersa.giza.entity.Endereco[id=" + id + "]";
    }

}
