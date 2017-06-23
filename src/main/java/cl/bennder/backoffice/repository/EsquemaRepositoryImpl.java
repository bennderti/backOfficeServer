package cl.bennder.backoffice.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Diego on 19-05-2017.
 */
@Repository
public class EsquemaRepositoryImpl implements EsquemaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void cambiarEsquema(String esquema) {
        Query query = entityManager.createNativeQuery("SET SESSION SEARCH_PATH TO " + esquema);
        query.executeUpdate();
    }
}
