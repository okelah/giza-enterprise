package br.com.heldersa.giza.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "endereco")
public class Endereco extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "tipo_endereco_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoEndereco tipoEndereco;

    @JoinColumn(name = "tipo_logradouro_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoLogradouro tipoLogradouro;

    @Basic(optional = false)
    @Column(name = "logradouro", nullable = false, length = 255)
    private String logradouro;

    @Column(name = "complemento", length = 255)
    private String complemento;

    @Column(name = "bairro", length = 255)
    private String bairro;

    @Column(name = "cep", length = 10)
    private String cep;

    @JoinColumn(name = "municipio_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Municipio municipio;

    public Endereco() {
    }

    public Endereco(Long id) {
        this.id = id;
    }

    public Endereco(Long id, boolean ativo, String logradouro) {
        this.id = id;
        this.ativo = ativo;
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
