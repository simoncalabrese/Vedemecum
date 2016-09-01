package model.dao;

import model.entity.Strumentation;

import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class StrumentationDao extends BaseDaoImplementation {

    public void insertStrumentazione(Strumentation strumentation) {
        insert(strumentation);

    }

    public void modificaStrumentazione(Strumentation strumentation) {
        update(strumentation);

    }

    public void deleteStrumentation(Integer id) {
        delete(findStrumentation(id));

    }

    public Strumentation findStrumentation(Integer id) {

        return find(id, Strumentation.class);
    }


    public List<Strumentation> totStrumentations() {
        return getAll(new Strumentation());
    }
}