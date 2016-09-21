package model.dao;

import model.entity.Space;

import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class SpaceDao extends BaseDaoImplementation{

    public Boolean insertSpace(Space space) {
        return insert(space);

    }

    public Boolean editSpace(Space space) {
        return update(space);

    }

    public Boolean deleteSpace(Integer id) {
        return delete(findSpace(id));

    }

    public Space findSpace(Integer id) {

        return find(id, Space.class);
    }


    public List<Space> totSpaces() {
        return getAll(new Space());
    }

}
