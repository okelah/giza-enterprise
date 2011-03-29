/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.heldersa.giza.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "rg", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numero"})})
@NamedQueries({
    @NamedQuery(name = "Rg.findAll", query = "SELECT r FROM Rg r"),
    @NamedQuery(name = "Rg.findById", query = "SELECT r FROM Rg r WHERE r.id = :id"),
    @NamedQuery(name = "Rg.findByAtivo", query = "SELECT r FROM Rg r WHERE r.ativo = :ativo"),
    @NamedQuery(name = "Rg.findByNumero", query = "SELECT r FROM Rg r WHERE r.numero = :numero"),
    @NamedQuery(name = "Rg.findByVia", query = "SELECT r FROM Rg r WHERE r.via = :via")})
public class Rg implements Serializable {

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
    @Column(name = "numero", nullable = false, length = 255)
    private String numero;

    @Basic(optional = false)
    @Column(name = "via", nullable = false)
    private short via;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rgId")
    private PessoaFisica pessoaFisica;

    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Estado estadoId;

    @JoinColumn(name = "orgao_emissor_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private OrgaoEmissor orgaoEmissorId;

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

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public OrgaoEmissor getOrgaoEmissorId() {
        return orgaoEmissorId;
    }

    public void setOrgaoEmissorId(OrgaoEmissor orgaoEmissorId) {
        this.orgaoEmissorId = orgaoEmissorId;
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

    @Override
    public String toString() {
        return "br.com.heldersa.giza.entity.Rg[id=" + id + "]";
    }

}
