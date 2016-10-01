package ejb.service;

import api.dto.AssociationDto;
import api.utils.UtilDate;
import api.utils.UtilValue;
import model.dao.*;
import model.entity.EmployeeStrumentation;
import model.entity.SpaceEmployee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class AssociationEmployeeStrumentationService extends BaseService<EmployeeStrumentationDao> {


    EmployeeStrumentationDao employeeStrumentationDao = new EmployeeStrumentationDao();
    EmployeeDao employeeDao = new EmployeeDao();
    StrumentationDao strumentationDao = new StrumentationDao();

    @Override
    public EmployeeStrumentationDao getDao() {
        return employeeStrumentationDao;
    }

    public EmployeeStrumentation getAssociationById(Integer id) {
        return getDao().findAssociation(id);
    }

    public Boolean insertAssociation(AssociationDto dto) {
        EmployeeStrumentation employeeStrumentation = new EmployeeStrumentation();
        employeeStrumentation.setId(UtilValue.toNumber(dto.getIdSpaceStrumentation(), Integer::valueOf));
        employeeStrumentation.setEmployee(employeeDao
                .findEmployee(UtilValue.toNumber(dto.getIdEmployee()
                        , Integer::valueOf))
        );
        employeeStrumentation.setStrumentation(strumentationDao
                .findStrumentation(UtilValue.toNumber(dto.getIdSpaceStrumentation()
                        , Integer::valueOf))
        );
        employeeStrumentation.setDtAssign(UtilDate.toDate(dto.getDateAssign()));
        return employeeStrumentationDao.insertAssociation(employeeStrumentation);

    }

    public Boolean deleteAssociation(Integer id) {
        return getDao().deleteAssociation(id);
    }

    public List<AssociationDto> getAllAssociation() {
        List<AssociationDto> dtos = new ArrayList<>();
        getDao().totAssociation().forEach(elem -> {
            AssociationDto dto = new AssociationDto();
            dto.setIdAssociation(elem.getId() != null
                    ? elem.getId().toString()
                    : null);
            dto.setIdEmployee(elem.getEmployee() != null
                    ? elem.getEmployee()
                    .getIdDipedente().toString()
                    : null);
            dto.setIdSpaceStrumentation(elem.getStrumentation() != null
                    ? elem.getStrumentation()
                    .getIdStrumentazione().toString()
                    : null);
            dto.setDateAssign(elem.getDtAssign() != null
                    ? UtilDate.toString(elem.getDtAssign())
                    : null);
            dtos.add(dto);
        });
        return dtos;
    }

}
