package br.com.heldersa.giza.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "pessoa_juridica", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cnpj"})})
@DiscriminatorValue(value="PJ")
public class PessoaJuridica extends Pessoa{

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "nome_fantasia", nullable = false, length = 255)
    private String nomeFantasia;

    @Basic(optional = false)
    @Column(name = "razao_social", nullable = false, length = 255)
    private String razaoSocial;

    @Basic(optional = false)
    @Column(name = "cnpj", nullable = false, length = 16)
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Long id) {
        this.id = id;
    }

    public PessoaJuridica(Long id, String nomeFantasia, String razaoSocial, String cnpj) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
