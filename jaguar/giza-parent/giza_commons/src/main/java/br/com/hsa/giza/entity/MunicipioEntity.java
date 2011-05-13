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
@Table(name="MUNICIPIO")
@SequenceGenerator(name="SE_MUNICIPIO", sequenceName="SE_MUNICIPIO")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="MunicipioEntity.queryMan", query="from MunicipioEntity"),
	@NamedQuery(name="MunicipioEntity.querySel", query="select obj.id as id, obj.nome as nome, obj1.id as unidadeFederativa_id , obj1.nome as unidadeFederativa_nome from MunicipioEntity obj left outer join obj.unidadeFederativa as obj1 order by obj.nome asc"),
	@NamedQuery(name="MunicipioEntity.querySelLookup", query="select id as id, nome as nome from MunicipioEntity where id = ? order by id asc")
})
public class MunicipioEntity extends Municipio {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrão
     */
    public MunicipioEntity() {
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
