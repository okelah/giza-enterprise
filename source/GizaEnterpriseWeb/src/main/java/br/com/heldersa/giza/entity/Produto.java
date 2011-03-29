package br.com.heldersa.giza.entity;

import java.math.BigDecimal;
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
@Table(name = "produto", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"referencia"}),
    @UniqueConstraint(columnNames = {"descricao"})})
public class Produto extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "referencia", length = 255)
    private String referencia;

    @Basic(optional = false)
    @Column(name = "genero", nullable = false, length = 255)
    private String genero;

    @Column(name = "faixa_etaria", length = 255)
    private String faixaEtaria;

    @Basic(optional = false)
    @Column(name = "desconto_maximo", nullable = false, precision = 18, scale = 5)
    private BigDecimal descontoMaximo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<ProdutoCor> produtoCorCollection;

    @JoinColumn(name = "tipo_produto_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoProduto tipoProduto;

    @JoinColumn(name = "fabricante_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Fabricante fabricante;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<ProdutoValor> produtoValorCollection;

    public Produto() {
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(Long id, boolean ativo, String descricao, String genero, BigDecimal descontoMaximo) {
        this.id = id;
        this.ativo = ativo;
        this.descricao = descricao;
        this.genero = genero;
        this.descontoMaximo = descontoMaximo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public BigDecimal getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(BigDecimal descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }

    public Collection<ProdutoCor> getProdutoCorCollection() {
        return produtoCorCollection;
    }

    public void setProdutoCorCollection(Collection<ProdutoCor> produtoCorCollection) {
        this.produtoCorCollection = produtoCorCollection;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricanted) {
        this.fabricante = fabricante;
    }

    public Collection<ProdutoValor> getProdutoValorCollection() {
        return produtoValorCollection;
    }

    public void setProdutoValorCollection(Collection<ProdutoValor> produtoValorCollection) {
        this.produtoValorCollection = produtoValorCollection;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
