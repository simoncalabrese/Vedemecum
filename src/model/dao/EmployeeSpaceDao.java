package model.dao;

import model.entity.SpaceEmployee;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class EmployeeSpaceDao extends BaseDaoImplementation {

    public Boolean insertAssociation(SpaceEmployee spaceEmployee) {
        return insert(spaceEmployee);

    }

    public Boolean deleteAssociation(Integer id) {
        return delete(findAssociation(id));

    }

    public SpaceEmployee findAssociation(Integer id) {

        return find(id, SpaceEmployee.class);
    }


    public List<SpaceEmployee> totAssociation() {

        return getAll(new SpaceEmployee());
    }
}
