/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.heldersa.giza.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "unidade_medida", catalog = "giza", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"abreviacao"}),
    @UniqueConstraint(columnNames = {"descricao"})})
@NamedQueries({
    @NamedQuery(name = "UnidadeMedida.findAll", query = "SELECT u FROM UnidadeMedida u"),
    @NamedQuery(name = "UnidadeMedida.findById", query = "SELECT u FROM UnidadeMedida u WHERE u.id = :id"),
    @NamedQuery(name = "UnidadeMedida.findByAtivo", query = "SELECT u FROM UnidadeMedida u WHERE u.ativo = :ativo"),
    @NamedQuery(name = "UnidadeMedida.findByDescricao", query = "SELECT u FROM UnidadeMedida u WHERE u.descricao = :descricao"),
    @NamedQuery(name = "UnidadeMedida.findByAbreviacao", query = "SELECT u FROM UnidadeMedida u WHERE u.abreviacao = :abreviacao")})
public class UnidadeMedida implements Serializable {

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

    @Column(name = "abreviacao", length = 9)
    private String abreviacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeMedidaId")
    private Collection<TipoProduto> tipoProdutoCollection;

    public UnidadeMedida() {
    }

    public UnidadeMedida(Long id) {
        this.id = id;
    }

    public UnidadeMedida(Long id, boolean ativo, String descricao) {
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

    public Collection<TipoProduto> getTipoProdutoCollection() {
        return tipoProdutoCollection;
    }

    public void setTipoProdutoCollection(Collection<TipoProduto> tipoProdutoCollection) {
        this.tipoProdutoCollection = tipoProdutoCollection;
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
        if (!(object instanceof UnidadeMedida)) {
            return false;
        }
        UnidadeMedida other = (UnidadeMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.heldersa.giza.entity.UnidadeMedida[id=" + id + "]";
    }

}
