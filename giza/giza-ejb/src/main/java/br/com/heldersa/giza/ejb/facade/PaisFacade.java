package br.com.heldersa.giza.ejb.facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.heldersa.giza.ejb.entity.Pais;

/**
 * Session Bean implementation class PaisFacade
 */
@Stateless
@LocalBean
public class PaisFacade extends AbstractFacade<Pais> {

	@PersistenceContext(unitName = "gizaPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PaisFacade() {
		super(Pais.class);
	}

}
