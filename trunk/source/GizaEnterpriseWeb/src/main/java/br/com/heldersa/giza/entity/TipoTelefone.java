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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tipo_telefone", catalog = "giza", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"abreviacao"}),
    @UniqueConstraint(columnNames = {"descricao"})})
@NamedQueries({
    @NamedQuery(name = "TipoTelefone.findAll", query = "SELECT t FROM TipoTelefone t"),
    @NamedQuery(name = "TipoTelefone.findById", query = "SELECT t FROM TipoTelefone t WHERE t.id = :id"),
    @NamedQuery(name = "TipoTelefone.findByAtivo", query = "SELECT t FROM TipoTelefone t WHERE t.ativo = :ativo"),
    @NamedQuery(name = "TipoTelefone.findByDescricao", query = "SELECT t FROM TipoTelefone t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "TipoTelefone.findByAbreviacao", query = "SELECT t FROM TipoTelefone t WHERE t.abreviacao = :abreviacao")})
public class TipoTelefone implements Serializable {

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
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "abreviacao", length = 50)
    private String abreviacao;

    public TipoTelefone() {
    }

    public TipoTelefone(Long id) {
        this.id = id;
    }

    public TipoTelefone(Long id, boolean ativo, String descricao) {
        this.id = id;
        this.ativo = ativo;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
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
        if (!(object instanceof TipoTelefone)) {
            return false;
        }
        TipoTelefone other = (TipoTelefone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.heldersa.giza.entity.TipoTelefone[id=" + id + "]";
    }

}
