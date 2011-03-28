/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.heldersa.giza.facade;

import br.com.heldersa.giza.entity.Pais;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class PaisFacade extends AbstractFacade<Pais> {

    @PersistenceContext(unitName = "GizaEnterpriseWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }

    public List<Pais> findByFiltros(String nome, String sigla, Boolean ativo) {

        Map<String, Object> parametros = new TreeMap<String, Object>();
        StringBuilder jpql = new StringBuilder("SELECT pais FROM Pais pais");

        jpql.append(" WHERE 1=1");
        if (nome != null && !nome.isEmpty()) {
            jpql.append(" AND lower(pais.nome) like lower(:nome)");
            parametros.put("nome", "%" + nome + "%");
        }

        if (sigla != null && !sigla.isEmpty()) {
            jpql.append(" AND lower(pais.sigla) like lower(:sigla)");
            parametros.put("sigla", "%" + sigla + "%");
        }

        if (ativo != null) {
            jpql.append(" AND pais.ativo = :ativo");
            parametros.put("ativo", ativo);
        }

        Query query = getEntityManager().createQuery(jpql.toString());
        for (String parametro : parametros.keySet()) {
            Object object = parametros.get(parametro);
            query.setParameter(parametro, object);
        }

        return query.getResultList();
    }
}
