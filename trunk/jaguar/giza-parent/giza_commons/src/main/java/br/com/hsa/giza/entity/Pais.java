package br.com.hsa.giza.entity;

import com.powerlogic.jcompany.domain.validation.PlcUnifiedValidation;
import com.powerlogic.jcompany.domain.validation.PlcValExactSize;
import com.powerlogic.jcompany.domain.validation.PlcValMask;
import com.powerlogic.jcompany.domain.validation.PlcValSimpleFormat;
import com.powerlogic.jcompany.domain.validation.PlcValSimpleFormat.FormatoSimples;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import org.hibernate.annotations.ForeignKey;

@MappedSuperclass
@PlcUnifiedValidation
public abstract class Pais extends AppBaseEntity {

	@OneToMany(targetEntity = br.com.hsa.giza.entity.UnidadeFederativaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pais")
	@ForeignKey(name = "FK_UNIDADEFEDERATIVA_PAIS")
	private List<UnidadeFederativa> unidadeFederativa;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_PAIS")
	@Column(nullable = false, length = 5)
	private Long id;

	@NotNull
	@Size(max = 255)
	@Column
	private String nome;

	@NotNull
	@PlcValSimpleFormat(formato = FormatoSimples.MAIUSCULO)
	@PlcValExactSize(tam = 3)
	@Column(nullable = false, length = 3)
	private String iso3166;

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

	public String getIso3166() {
		return iso3166;
	}

	public void setIso3166(String iso3166) {
		this.iso3166 = iso3166;
	}

	public List<UnidadeFederativa> getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(List<UnidadeFederativa> unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

}
