package br.com.hsa.giza.persistence.jpa.unidadefederativa;

import br.com.hsa.giza.persistence.jpa.AppJpaDAO;
import br.com.hsa.giza.entity.UnidadeFederativaEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import br.com.hsa.giza.entity.Pais;

import java.util.List;

import com.powerlogic.jcompany.persistence.jpa.PlcQuery;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryLineAmount;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryOrderBy;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryFirstLine;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;

/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(UnidadeFederativaEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class UnidadeFederativaDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<UnidadeFederativaEntity> findList(
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like '%' || :nome || '%' ") String nome,
			@PlcQueryParameter(name="sigla", expression="obj.sigla like '%' || :sigla || '%' ") String sigla,
			@PlcQueryParameter(name="pais", expression="obj.pais = :pais") Pais pais
	);

	@PlcQuery("querySel")
	public native Long findCount(
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like '%' || :nome || '%' ") String nome,
			@PlcQueryParameter(name="sigla", expression="obj.sigla like '%' || :sigla || '%' ") String sigla,
			@PlcQueryParameter(name="pais", expression="obj.pais = :pais") Pais pais
	);
	
}
