package ejb.service;

import api.dto.RoleDto;
import ejb.converter.RoleConverter;
import model.dao.RoleDao;
import model.entity.Role;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class RoleService extends BaseService<RoleDao> {
    @Inject
    private RoleDao mansioneDao;

    @Override
    public RoleDao getDao() {
        return mansioneDao;
    }

    public Role getMansioneById(Integer id) {
        return getDao().findRole(id);
    }

    public Boolean insertMansione(RoleDto roleDto) {
        return getDao().insertROle(converter(roleDto, RoleConverter.ToEntity.toMansioneEntity));
    }

    public Boolean updateMansione(RoleDto roleDto) {
        return getDao().editRole(converter(roleDto, RoleConverter.ToEntity.toMansioneEntity));
    }

    public Boolean deleteMansione(Integer idRole) {
        return getDao().deleteRole(idRole);
    }

    public List<RoleDto> getAllMansioni() {
        return converter(getDao().totRoles(), RoleConverter.ToDto.toMansioneDto);
    }


}
