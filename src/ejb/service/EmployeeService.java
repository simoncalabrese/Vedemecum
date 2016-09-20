package ejb.service;

import api.dto.EmployeeDto;
import api.dto.RoleDto;
import ejb.converter.EmployeeConverter;
import ejb.converter.RoleConverter;
import model.dao.EmployeeDao;
import model.dao.RoleDao;
import model.entity.Employee;

import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class EmployeeService extends BaseService<EmployeeDao> {

    private EmployeeDao employeeDao = new EmployeeDao();
    private RoleDao roleDao = new RoleDao();

    @Override
    public EmployeeDao getDao() {
        return employeeDao;
    }

    public Employee getEmployeeById(Integer id) {
        return getDao().findEmployee(id);
    }

    public Boolean insertEmployee(EmployeeDto employeeDto) {
        RoleDto role = converter(roleDao.getIdRoleByDes(employeeDto.getRole()), RoleConverter.ToDto.toMansioneDto);
        return getDao()
                .insertEmployee(
                        biconverter(employeeDto, role, EmployeeConverter.ToEntity.toEmployeeEntity));
    }

    public Boolean updateEmployee(EmployeeDto employeeDto, String oldCf) {
        RoleDto role = converter(roleDao.getIdRoleByDes(employeeDto.getRole()), RoleConverter.ToDto.toMansioneDto);
        employeeDto.setIdDipedente(
                employeeDao.getEmployeeIdByCF(oldCf)
                        .getIdDipedente()
                        .toString());
        return getDao()
                .editDipendente(
                        biconverter(employeeDto, role, EmployeeConverter.ToEntity.toEmployeeEntity));
    }

    public Boolean deleteEmployee(String cf) {
        return getDao().deleteEmployee(getDao().getEmployeeIdByCF(cf).getIdDipedente());
    }

    public List<EmployeeDto> getAllEmployees() {
        return converter(getDao().totEmployees(), EmployeeConverter.ToDto.toEmployeeDto);
    }

}
