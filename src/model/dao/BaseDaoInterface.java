package model.dao;

import java.util.List;

/**
 * Created by simon on 30/08/16.
 */
public interface BaseDaoInterface {
    /**
     * @param id primary key for every Entity
     * @return All record with param id
     */
    <T> T find(Integer id, Class<T> entity);

    /**
     * @return All records returned with param query
     */
    <T> List getAll(T entity);


    /**
     * Insert data value in DB
     * @param entity
     */
    <T> Boolean insert(T entity);

    /**
     * Update Record with data value
     * @param entity
     */
    <T> Boolean update(T entity);

    /**
     * Delete Record with data value
     * @param entity
     */
    <T> Boolean delete(T entity);

}



