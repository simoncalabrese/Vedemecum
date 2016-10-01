package ejb.service;

import api.dto.AssociationDto;
import api.utils.UtilValue;
import model.dao.EmployeeDao;
import model.dao.EmployeeSpaceDao;
import model.dao.SpaceDao;
import model.entity.SpaceEmployee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class AssociationEmployeeSpaceService extends BaseService<EmployeeSpaceDao> {


    EmployeeSpaceDao employeeSpaceDao = new EmployeeSpaceDao();
    EmployeeDao employeeDao = new EmployeeDao();
    SpaceDao spaceDao = new SpaceDao();

    @Override
    public EmployeeSpaceDao getDao() {
        return employeeSpaceDao;
    }

    public SpaceEmployee getAssociationById(Integer id) {
        return getDao().findAssociation(id);
    }

    public Boolean insertAssociation(AssociationDto dto) {
        SpaceEmployee spaceEmployee = new SpaceEmployee();
        spaceEmployee.setId(UtilValue.toNumber(dto.getIdSpaceStrumentation(), Integer::valueOf));
        spaceEmployee.setEmployee(employeeDao
                .findEmployee(UtilValue.toNumber(dto.getIdEmployee()
                        , Integer::valueOf))
        );
        spaceEmployee.setSpace(spaceDao
                .findSpace(UtilValue.toNumber(dto.getIdSpaceStrumentation()
                        , Integer::valueOf))
        );
        return employeeSpaceDao.insertAssociation(spaceEmployee);

    }

    public Boolean deleteAssociation(Integer id) {
        return getDao().deleteAssociation(id);
    }

    public List<AssociationDto> getAllAssociation() {
        List<AssociationDto> dtos = new ArrayList<>();
        getDao().totAssociation().forEach(spaceEmployee -> {
            AssociationDto dto = new AssociationDto();
            dto.setIdAssociation(spaceEmployee.getId() != null
                    ? spaceEmployee.getId().toString()
                    : null);
            dto.setIdEmployee(spaceEmployee.getEmployee() != null
                    ? spaceEmployee.getEmployee()
                    .getIdDipedente().toString()
                    : null);
            dto.setIdSpaceStrumentation(spaceEmployee.getSpace() != null
                    ? spaceEmployee.getSpace()
                    .getIdImpianto().toString()
                    : null);
            dtos.add(dto);
        });
        return dtos;
    }

}
