package model.dao;

import model.entity.Strumentation;

import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class StrumentationDao extends BaseDaoImplementation {

    public Boolean insertStrumentazione(Strumentation strumentation) {
        return insert(strumentation);

    }

    public Boolean modificaStrumentazione(Strumentation strumentation) {
        return update(strumentation);

    }

    public Boolean deleteStrumentation(Integer id) {
        return delete(findStrumentation(id));

    }

    public Strumentation findStrumentation(Integer id) {

        return find(id, Strumentation.class);
    }


    public List<Strumentation> totStrumentations() {
        return getAll(new Strumentation());
    }
}