package ejb.service;

import api.dto.EmployeeDto;
import api.dto.RoleDto;
import ejb.converter.EmployeeConverter;
import ejb.converter.RoleConverter;
import model.dao.EmployeeDao;
import model.dao.RoleDao;
import model.entity.Employee;
import model.entity.Role;

import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class EmployeeService extends BaseService<EmployeeDao> {

    private EmployeeDao roleDao = new EmployeeDao();

    @Override
    public EmployeeDao getDao() {
        return roleDao;
    }

    public Employee getEmployeeById(Integer id) {
        return getDao().findEmployee(id);
    }

    public Boolean insertEmployee(EmployeeDto employeeDto) {
        return getDao().insertEmployee(converter(employeeDto, EmployeeConverter.ToEntity.toEmployeeEntity));
    }

    public Boolean updateEmployee(EmployeeDto employeeDto) {
        return getDao().editDipendente(converter(employeeDto, EmployeeConverter.ToEntity.toEmployeeEntity));
    }

    public Boolean deleteEmployee(Integer idRole) {
        return getDao().deleteEmployee(idRole);
    }

    public List<EmployeeDto> getAllEmployees() {
        return converter(getDao().totEmployees(),EmployeeConverter.ToDto.toEmployeeDto);
    }

}
