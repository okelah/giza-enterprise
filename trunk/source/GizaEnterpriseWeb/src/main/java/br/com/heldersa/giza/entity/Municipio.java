package br.com.heldersa.giza.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "municipio", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome", "estado_id"})})
public class Municipio extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false)
    private String nome;

    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Estado estado;

    public Municipio() {
    }

    public Municipio(Long id) {
        this.id = id;
    }

    public Municipio(Long id, boolean ativo, String nome) {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
