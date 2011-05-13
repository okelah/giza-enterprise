package br.com.hsa.giza.controller.jsf.unidadefederativa;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import br.com.hsa.giza.entity.UnidadeFederativaEntity;
import br.com.hsa.giza.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigCollaboration;


import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.com.hsa.giza.entity.UnidadeFederativaEntity.class

		,details = { 		@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = br.com.hsa.giza.entity.MunicipioEntity.class,
								collectionName = "municipio", numNew = 4,
								multiplicity = "0..*", onDemand = false)
			

		}
	)
	



@PlcConfigCollaboration (
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/unidadefederativa")
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("unidadefederativa")
@PlcHandleException
public class UnidadefederativaMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("unidadefederativa")
	public UnidadeFederativaEntity criaEntidadePlc() {

        if (this.entidadePlc==null) {
              this.entidadePlc = new UnidadeFederativaEntity();
              this.newEntity();
        }

        return (UnidadeFederativaEntity)this.entidadePlc;
        
	}	
}
