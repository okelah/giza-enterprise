/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.heldersa.giza.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "produto_valor", catalog = "giza", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"inicio_vigencia", "produto_id"})})
@NamedQueries({
    @NamedQuery(name = "ProdutoValor.findAll", query = "SELECT p FROM ProdutoValor p"),
    @NamedQuery(name = "ProdutoValor.findById", query = "SELECT p FROM ProdutoValor p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutoValor.findByAtivo", query = "SELECT p FROM ProdutoValor p WHERE p.ativo = :ativo"),
    @NamedQuery(name = "ProdutoValor.findByPrecoVenda", query = "SELECT p FROM ProdutoValor p WHERE p.precoVenda = :precoVenda"),
    @NamedQuery(name = "ProdutoValor.findByInicioVigencia", query = "SELECT p FROM ProdutoValor p WHERE p.inicioVigencia = :inicioVigencia")})
public class ProdutoValor implements Serializable {

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
    @Column(name = "preco_venda", nullable = false, precision = 18, scale = 2)
    private BigDecimal precoVenda;

    @Basic(optional = false)
    @Column(name = "inicio_vigencia", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioVigencia;

    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Produto produtoId;

    public ProdutoValor() {
    }

    public ProdutoValor(Long id) {
        this.id = id;
    }

    public ProdutoValor(Long id, boolean ativo, BigDecimal precoVenda, Date inicioVigencia) {
        this.id = id;
        this.ativo = ativo;
        this.precoVenda = precoVenda;
        this.inicioVigencia = inicioVigencia;
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

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
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
        if (!(object instanceof ProdutoValor)) {
            return false;
        }
        ProdutoValor other = (ProdutoValor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.heldersa.giza.entity.ProdutoValor[id=" + id + "]";
    }

}
