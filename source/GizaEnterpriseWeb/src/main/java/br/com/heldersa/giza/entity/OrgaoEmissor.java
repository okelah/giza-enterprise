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
@Table(name = "orgao_emissor", catalog = "giza", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sigla"}),
    @UniqueConstraint(columnNames = {"nome"})})
@NamedQueries({
    @NamedQuery(name = "OrgaoEmissor.findAll", query = "SELECT o FROM OrgaoEmissor o"),
    @NamedQuery(name = "OrgaoEmissor.findById", query = "SELECT o FROM OrgaoEmissor o WHERE o.id = :id"),
    @NamedQuery(name = "OrgaoEmissor.findByAtivo", query = "SELECT o FROM OrgaoEmissor o WHERE o.ativo = :ativo"),
    @NamedQuery(name = "OrgaoEmissor.findByNome", query = "SELECT o FROM OrgaoEmissor o WHERE o.nome = :nome"),
    @NamedQuery(name = "OrgaoEmissor.findBySigla", query = "SELECT o FROM OrgaoEmissor o WHERE o.sigla = :sigla")})
public class OrgaoEmissor implements Serializable {

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
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgaoEmissorId")
    private Collection<Rg> rgCollection;

    public OrgaoEmissor() {
    }

    public OrgaoEmissor(Long id) {
        this.id = id;
    }

    public OrgaoEmissor(Long id, boolean ativo, String nome, String sigla) {
        this.id = id;
        this.ativo = ativo;
        this.nome = nome;
        this.sigla = sigla;
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

    public Collection<Rg> getRgCollection() {
        return rgCollection;
    }

    public void setRgCollection(Collection<Rg> rgCollection) {
        this.rgCollection = rgCollection;
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
        if (!(object instanceof OrgaoEmissor)) {
            return false;
        }
        OrgaoEmissor other = (OrgaoEmissor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.heldersa.giza.entity.OrgaoEmissor[id=" + id + "]";
    }

}
