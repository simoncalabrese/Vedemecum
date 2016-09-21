package ejb.service;

import api.dto.RoleDto;
import api.dto.SpaceDto;
import ejb.converter.RoleConverter;
import ejb.converter.SpaceConverter;
import model.dao.RoleDao;
import model.dao.SpaceDao;
import model.entity.Role;
import model.entity.Space;

import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class SpaceService extends BaseService<SpaceDao> {

    private SpaceDao spaceDao = new SpaceDao();

    @Override
    public SpaceDao getDao() {
        return spaceDao;
    }

    public Space getSpaceById(Integer id) {
        return getDao().findSpace(id);
    }

    public Boolean insertSpace(SpaceDto spaceDto) {
        spaceDto.setIdSpace(null);
        return getDao().insertSpace(converter(spaceDto, SpaceConverter.ToEntity.toSpaceEntity));

    }

    public Boolean upadteSpace(SpaceDto spaceDto) {
        return getDao().editSpace(converter(spaceDto,SpaceConverter.ToEntity.toSpaceEntity));

    }

    public Boolean deleteSpace(Integer id) {
        return getDao().deleteSpace(id);
    }

    public List<SpaceDto> getAllSpace() {
        return converter(getDao().totSpaces(), SpaceConverter.ToDto.toSpaceDto);
    }

}
