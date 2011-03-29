package br.com.heldersa.giza.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "produto_cor", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cor_id", "produto_id"})})
public class ProdutoCor extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Produto produto;

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

    public Produto getProdutoId() {
        return produto;
    }

    public void setProdutoId(Produto produtoId) {
        this.produto = produtoId;
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

}
