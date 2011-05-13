package br.com.hsa.giza.controller.jsf.pais;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import br.com.hsa.giza.entity.PaisEntity;
import br.com.hsa.giza.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigCollaboration;


import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.com.hsa.giza.entity.PaisEntity.class

		,details = { 		@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = br.com.hsa.giza.entity.UnidadeFederativaEntity.class,
								collectionName = "unidadeFederativa", numNew = 4,
								multiplicity = "0..*", onDemand = false)
			

		}
	)
	



@PlcConfigCollaboration (
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/pais")
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("pais")
@PlcHandleException
public class PaisMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("pais")
	public PaisEntity criaEntidadePlc() {

        if (this.entidadePlc==null) {
              this.entidadePlc = new PaisEntity();
              this.newEntity();
        }

        return (PaisEntity)this.entidadePlc;
        
	}	
}
