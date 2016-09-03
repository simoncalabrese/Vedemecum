package model.dao;


import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;


/**
 * Created by simon on 30/08/16.
 */
public class BaseDaoImplementation implements BaseDaoInterface {


    private EntityManager entityManager = Persistence.createEntityManagerFactory("jpa").createEntityManager();

    private EntityTransaction transaction = entityManager.getTransaction();

    public <T> T find(Integer id, Class<T> entity) {
        return entityManager.find(entity, id);
    }


    @SuppressWarnings("unchecked")
    public <T> List<T> getAll(T entity) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(entity.getClass());
        Root root = query.from(entity.getClass());
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }


    public <T> Boolean insert(T entity) {
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public <T> Boolean update(T entity) {
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }

    public <T> Boolean delete(T entity) {
        try {
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }


}
