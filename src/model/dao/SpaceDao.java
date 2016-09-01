package model.dao;

import model.entity.Space;

import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class SpaceDao extends BaseDaoImplementation{

    public void insertSpace(Space space) {
        insert(space);

    }

    public void editSpace(Space space) {
        update(space);

    }

    public void deleteSpace(Integer id) {
        delete(findSpace(id));

    }

    public Space findSpace(Integer id) {

        return find(id, Space.class);
    }


    public List<Space> totSpaces() {
        return getAll(new Space());
    }

}
