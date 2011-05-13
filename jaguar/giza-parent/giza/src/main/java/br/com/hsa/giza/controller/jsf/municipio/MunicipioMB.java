package br.com.hsa.giza.controller.jsf.municipio;

import javax.enterprise.inject.Produces;
import javax.inject.Named;


import br.com.hsa.giza.entity.MunicipioEntity;
import br.com.hsa.giza.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigCollaboration;



import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.com.hsa.giza.entity.MunicipioEntity.class
		
	)
	



@PlcConfigCollaboration (
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/municipio")
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("municipio")
@PlcHandleException
public class MunicipioMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("municipio")
	public MunicipioEntity criaEntidadePlc() {

        if (this.entidadePlc==null) {
              this.entidadePlc = new MunicipioEntity();
              this.newEntity();
        }

        return (MunicipioEntity)this.entidadePlc;
        
	}	
}
