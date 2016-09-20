package model.dao;

import model.entity.Employee;
import model.entity.Employee_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public Employee getEmployeeIdByCF(String codFiscale) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root);
        query.where(cb.equal(root.get(Employee_.codFiscale),codFiscale));
        return entityManager.createQuery(query).getSingleResult();

    }
}
