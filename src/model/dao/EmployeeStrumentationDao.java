package model.dao;

import model.entity.EmployeeStrumentation;
import model.entity.SpaceEmployee;

import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class EmployeeStrumentationDao extends BaseDaoImplementation {

    public Boolean insertAssociation(EmployeeStrumentation employeeStrumentation) {
        return insert(employeeStrumentation);

    }

    public Boolean deleteAssociation(Integer id) {
        return delete(findAssociation(id));

    }

    public EmployeeStrumentation findAssociation(Integer id) {

        return find(id, EmployeeStrumentation.class);
    }


    public List<EmployeeStrumentation> totAssociation() {

        return getAll(new EmployeeStrumentation());
    }
}
