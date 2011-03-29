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
@Table(name = "rg", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numero"})})
public class Rg extends AbstractEntity{

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "numero", nullable = false, length = 255)
    private String numero;

    @Basic(optional = false)
    @Column(name = "via", nullable = false)
    private short via;

    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Estado estado;

    @JoinColumn(name = "orgao_emissor_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OrgaoEmissor orgaoEmissor;

    public Rg() {
    }

    public Rg(Long id) {
        this.id = id;
    }

    public Rg(Long id, boolean ativo, String numero, short via) {
        this.id = id;
        this.ativo = ativo;
        this.numero = numero;
        this.via = via;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public short getVia() {
        return via;
    }

    public void setVia(short via) {
        this.via = via;
    }


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public OrgaoEmissor getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(OrgaoEmissor orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
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
        if (!(object instanceof Rg)) {
            return false;
        }
        Rg other = (Rg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
