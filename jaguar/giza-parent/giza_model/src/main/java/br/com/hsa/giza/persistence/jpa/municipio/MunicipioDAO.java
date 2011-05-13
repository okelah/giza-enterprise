package br.com.hsa.giza.persistence.jpa.municipio;

import br.com.hsa.giza.persistence.jpa.AppJpaDAO;
import br.com.hsa.giza.entity.MunicipioEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import br.com.hsa.giza.entity.UnidadeFederativa;

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

@PlcAggregationDAOIoC(MunicipioEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class MunicipioDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<MunicipioEntity> findList(
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like '%' || :nome || '%' ") String nome,
			@PlcQueryParameter(name="unidadeFederativa", expression="obj.unidadeFederativa = :unidadeFederativa") UnidadeFederativa unidadeFederativa
	);

	@PlcQuery("querySel")
	public native Long findCount(
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="nome", expression="obj.nome like '%' || :nome || '%' ") String nome,
			@PlcQueryParameter(name="unidadeFederativa", expression="obj.unidadeFederativa = :unidadeFederativa") UnidadeFederativa unidadeFederativa
	);
	
}
