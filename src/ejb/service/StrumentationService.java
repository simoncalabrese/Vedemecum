package ejb.service;

import api.dto.EmployeeDto;
import api.dto.RoleDto;
import api.dto.StrumentationDto;
import ejb.converter.EmployeeConverter;
import ejb.converter.RoleConverter;
import ejb.converter.StrumentationConverter;
import model.dao.EmployeeDao;
import model.dao.RoleDao;
import model.dao.StrumentationDao;
import model.entity.Employee;
import model.entity.Strumentation;

import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class StrumentationService extends BaseService<StrumentationDao> {

    private StrumentationDao strumentationDao = new StrumentationDao();

    @Override
    public StrumentationDao getDao() {
        return strumentationDao;
    }

    public Strumentation getStrumentationById(Integer id) {
        return getDao().findStrumentation(id);
    }

    public Boolean insertStrumentation(StrumentationDto strumentationDto) {
        return null;
    }

    public Boolean updateStrumentation(StrumentationDto strumentationDto) {
        return null;
    }

    public Boolean deleteStrumentation(Integer id) {
        return null;
    }

    public List<StrumentationDto> getAllStrumentation() {
        return converter(getDao().totStrumentations(), StrumentationConverter.ToDto.toStrumentationDto);
    }

}
