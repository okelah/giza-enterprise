package br.com.heldersa.giza.entity;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tipo_endereco", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"abreviacao"}),
    @UniqueConstraint(columnNames = {"descricao"})})
public class TipoEndereco extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "abreviacao", length = 50)
    private String abreviacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEnderecoId")
    private Collection<Endereco> enderecoCollection;

    public TipoEndereco() {
    }

    public TipoEndereco(Long id) {
        this.id = id;
    }

    public TipoEndereco(Long id, boolean ativo, String descricao) {
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

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
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
        if (!(object instanceof TipoEndereco)) {
            return false;
        }
        TipoEndereco other = (TipoEndereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
