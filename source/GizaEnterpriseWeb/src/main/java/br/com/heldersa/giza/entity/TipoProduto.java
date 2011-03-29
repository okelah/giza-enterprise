package br.com.heldersa.giza.entity;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tipo_produto", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"descricao"})})
public class TipoProduto extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProdutoId")
    private Collection<Produto> produtoCollection;

    @JoinColumn(name = "unidade_medida_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UnidadeMedida unidadeMedida;

    public TipoProduto() {
    }

    public TipoProduto(Long id) {
        this.id = id;
    }

    public TipoProduto(Long id, boolean ativo, String descricao) {
        this.id = id;
        this.ativo = ativo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    public UnidadeMedida getUnidadeMedidaId() {
        return unidadeMedida;
    }

    public void setUnidadeMedidaId(UnidadeMedida unidadeMedidaId) {
        this.unidadeMedida = unidadeMedidaId;
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
        if (!(object instanceof TipoProduto)) {
            return false;
        }
        TipoProduto other = (TipoProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
