package br.com.hsa.giza.entity;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Entity;
import javax.persistence.Transient;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="UNIDADE_FEDERATIVA")
@SequenceGenerator(name="SE_UNIDADE_FEDERATIVA", sequenceName="SE_UNIDADE_FEDERATIVA")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="UnidadeFederativaEntity.queryMan", query="from UnidadeFederativaEntity"),
	@NamedQuery(name="UnidadeFederativaEntity.querySel", query="select obj.id as id, obj.nome as nome, obj.sigla as sigla, obj1.id as pais_id , obj1.nome as pais_nome from UnidadeFederativaEntity obj left outer join obj.pais as obj1 order by obj.nome asc"),
	@NamedQuery(name="UnidadeFederativaEntity.querySelLookup", query="select id as id, nome as nome from UnidadeFederativaEntity where id = ? order by id asc")
})
public class UnidadeFederativaEntity extends UnidadeFederativa {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrão
     */
    public UnidadeFederativaEntity() {
    }
	@Override
	public String toString() {
		return getNome();
	}

	@Transient
	private transient String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
