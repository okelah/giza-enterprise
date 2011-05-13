package br.com.hsa.giza.entity;

import com.powerlogic.jcompany.domain.validation.PlcUnifiedValidation;
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

@MappedSuperclass
@PlcUnifiedValidation
public abstract class Municipio extends AppBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_MUNICIPIO")
	@Column(nullable = false, length = 5)
	private Long id;

	@ManyToOne(targetEntity = UnidadeFederativaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_MUNICIPIO_UNIDADEFEDERATIVA")
	@NotNull
	@JoinColumn
	private UnidadeFederativa unidadeFederativa;

	@NotNull
	@Size(max = 255)
	@Column
	@PlcReference(testDuplicity = true)
	private String nome;

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

	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

}
