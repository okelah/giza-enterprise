package br.com.hsa.giza.entity;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Entity;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="PAIS")
@SequenceGenerator(name="SE_PAIS", sequenceName="SE_PAIS")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="PaisEntity.queryMan", query="from PaisEntity"),
	@NamedQuery(name="PaisEntity.querySel", query="select id as id, nome as nome, iso3166 as iso3166 from PaisEntity order by nome asc"),
	@NamedQuery(name="PaisEntity.querySelLookup", query="select id as id, nome as nome from PaisEntity where id = ? order by id asc")
})
public class PaisEntity extends Pais {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrão
     */
    public PaisEntity() {
    }
	@Override
	public String toString() {
		return getNome();
	}

}
