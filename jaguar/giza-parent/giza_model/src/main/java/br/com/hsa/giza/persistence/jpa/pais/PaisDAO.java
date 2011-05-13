package br.com.hsa.giza.persistence.jpa.pais;

import br.com.hsa.giza.persistence.jpa.AppJpaDAO;
import br.com.hsa.giza.entity.PaisEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;

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

@PlcAggregationDAOIoC(PaisEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class PaisDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<PaisEntity> findList(
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="nome like '%' || :nome || '%' ") String nome,
			@PlcQueryParameter(name="iso3166", expression="iso3166 like '%' || :iso3166 || '%' ") String iso3166
	);

	@PlcQuery("querySel")
	public native Long findCount(
			
			@PlcQueryParameter(name="id", expression="id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="nome like '%' || :nome || '%' ") String nome,
			@PlcQueryParameter(name="iso3166", expression="iso3166 like '%' || :iso3166 || '%' ") String iso3166
	);
	
}
