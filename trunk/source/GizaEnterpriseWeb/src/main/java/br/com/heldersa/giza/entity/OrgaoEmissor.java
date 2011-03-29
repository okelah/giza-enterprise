package br.com.heldersa.giza.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "orgao_emissor", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sigla"}),
    @UniqueConstraint(columnNames = {"nome"})})
public class OrgaoEmissor extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Basic(optional = false)
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;

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
}
