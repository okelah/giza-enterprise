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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "produto_cor", catalog = "giza", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cor_id", "produto_id"})})
@NamedQueries({
    @NamedQuery(name = "ProdutoCor.findAll", query = "SELECT p FROM ProdutoCor p"),
    @NamedQuery(name = "ProdutoCor.findById", query = "SELECT p FROM ProdutoCor p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutoCor.findByAtivo", query = "SELECT p FROM ProdutoCor p WHERE p.ativo = :ativo")})
public class ProdutoCor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Produto produtoId;

    @JoinColumn(name = "cor_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Cor corId;

    public ProdutoCor() {
    }

    public ProdutoCor(Long id) {
        this.id = id;
    }

    public ProdutoCor(Long id, boolean ativo) {
        this.id = id;
        this.ativo = ativo;
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

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    public Cor getCorId() {
        return corId;
    }

    public void setCorId(Cor corId) {
        this.corId = corId;
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
        if (!(object instanceof ProdutoCor)) {
            return false;
        }
        ProdutoCor other = (ProdutoCor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.heldersa.giza.entity.ProdutoCor[id=" + id + "]";
    }

}
