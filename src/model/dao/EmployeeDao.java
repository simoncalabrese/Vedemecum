package model.dao;

import model.entity.Employee;

import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
public class EmployeeDao extends BaseDaoImplementation {

    public void insertEmployee(Employee employee) {
        insert(employee);

    }

    public void editDipendente(Employee employee) {
        update(employee);

    }

    public void deleteEmployee(Integer id) {
        delete(findEmployee(id));

    }

    public Employee findEmployee(Integer id) {

        return find(id, Employee.class);
    }


    public List<Employee> totEmployees() {

        return getAll(new Employee());
    }
}
