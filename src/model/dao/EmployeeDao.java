package model.dao;

import model.entity.Employee;

import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class EmployeeDao extends BaseDaoImplementation {

    public Boolean insertEmployee(Employee employee) {
        return insert(employee);

    }

    public Boolean editDipendente(Employee employee) {
        return update(employee);

    }

    public Boolean deleteEmployee(Integer id) {
        return delete(findEmployee(id));

    }

    public Employee findEmployee(Integer id) {

        return find(id, Employee.class);
    }


    public List<Employee> totEmployees() {

        return getAll(new Employee());
    }
}
