package br.com.hsa.giza.entity;

import com.powerlogic.jcompany.domain.validation.PlcUnifiedValidation;
import com.powerlogic.jcompany.domain.validation.PlcValExactSize;
import com.powerlogic.jcompany.domain.validation.PlcValSimpleFormat;
import com.powerlogic.jcompany.domain.validation.PlcValSimpleFormat.FormatoSimples;

import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import com.powerlogic.jcompany.config.domain.PlcReference;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.GeneratedValue;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@MappedSuperclass
@PlcUnifiedValidation
public abstract class UnidadeFederativa extends AppBaseEntity {

	@OneToMany(targetEntity = br.com.hsa.giza.entity.MunicipioEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "unidadeFederativa")
	@ForeignKey(name = "FK_MUNICIPIO_UNIDADEFEDERATIVA")
	private List<Municipio> municipio;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_UNIDADE_FEDERATIVA")
	@Column(nullable = false, length = 5)
	private Long id;

	@ManyToOne(targetEntity = PaisEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_UNIDADEFEDERATIVA_PAIS")
	@NotNull
	@JoinColumn
	private Pais pais;

	@NotNull
	@Size(max = 255)
	@Column
	@PlcReference(testDuplicity = true)
	private String nome;

	@NotNull
	@PlcValSimpleFormat(formato = FormatoSimples.MAIUSCULO)
	@PlcValExactSize(tam = 2)
	@Column(nullable = false, length = 2)
	private String sigla;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Municipio> getMunicipio() {
		return municipio;
	}

	public void setMunicipio(List<Municipio> municipio) {
		this.municipio = municipio;
	}

}
