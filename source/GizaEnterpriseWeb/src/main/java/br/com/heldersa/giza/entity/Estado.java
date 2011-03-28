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
@Table(name = "estado", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome", "pais_id"}),
    @UniqueConstraint(columnNames = {"sigla", "pais_id"})})
public class Estado extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false)
    private String nome;

    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 2)
    private String sigla;

    @JoinColumn(name = "pais_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pais pais;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Municipio> municipioCollection;

    public Estado() {
    }

    public Estado(Long id) {
        this.id = id;
    }

    public Estado(Long id, boolean ativo, String nome, String sigla) {
        this.id = id;
        this.ativo = ativo;
        this.nome = nome;
        this.sigla = sigla;
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
        this.sigla = sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Collection<Municipio> getMunicipioCollection() {
        return municipioCollection;
    }

    public void setMunicipioCollection(Collection<Municipio> municipioCollection) {
        this.municipioCollection = municipioCollection;
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
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
