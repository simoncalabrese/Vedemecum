package ejb.converter;


import api.dto.RoleDto;
import model.entity.Role;

/**
 * Created by simon on 31/08/16.
 */
public class RoleConverter {

    public static class ToEntity {
        public static SuperConverter<RoleDto, Role> toMansioneEntity =
                dto -> {
                    Role entity = new Role();
                    entity.setIdRole(dto.getIdRole()!=null ?
                            Integer.valueOf(dto.getIdRole().getValue())
                    : null);
                    entity.setCodRole(dto.getCodRole().getValue());
                    entity.setDesRole(dto.getDesRole().getValue());
                    return entity;
                };
    }

    public static class ToDto {
        public static SuperConverter<Role,RoleDto> toMansioneDto =
                entity -> {
                    RoleDto dto = new RoleDto();
                    dto.setIdRole(entity.getIdRole());
                    dto.setCodRole(entity.getCodRole());
                    dto.setDesRole(entity.getDesRole());
                    return dto;
                };
    }


}
