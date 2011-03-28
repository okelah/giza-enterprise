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
@Table(name = "pais", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome"})})
public class Pais extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sigla", length = 3)
    private String sigla;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<Estado> estadoCollection;

    public Pais() {
    }

    public Pais(Long id) {
        this.id = id;
    }

    public Pais(Long id, boolean ativo, String nome) {
        this.id = id;
        this.ativo = ativo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
    }

    public Collection<Estado> getEstadoCollection() {
        return estadoCollection;
    }

    public void setEstadoCollection(Collection<Estado> estadoCollection) {
        this.estadoCollection = estadoCollection;
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
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
