package ejb.converter;


import api.dto.SpaceDto;
import model.entity.Space;

/**
 * Created by simon on 31/08/16.
 */
public class SpaceConverter {

    public static class ToEntity {
        public static SuperConverter<SpaceDto, Space> toSpaceEntity =
                (dto) -> {
                    Space space = new Space();
                    space.setIdImpianto(dto.getIdSpace() != null
                            ? Integer.valueOf(dto.getIdSpace())
                            : null);
                    space.setDesImpianto(dto.getDesSpace());
                    space.setAddImpianto(dto.getAddressSpace());
                    space.setRoomNo(dto.getAmntRoom() != null
                            ? Integer.valueOf(dto.getAmntRoom())
                            : 0);
                    space.setDoorNo(dto.getAmntDoor() != null
                            ? Integer.valueOf(dto.getAmntRoom())
                            : 0);
                    space.setWindowsNo(dto.getAmntWindow() != null
                            ? Integer.valueOf(dto.getAmntWindow())
                            : 0);
                    return space;
                };
    }

    public static class ToDto {
        public static SuperConverter<Space, SpaceDto> toSpaceDto =
                entity -> {
                    if (entity == null) {
                        return null;
                    }
                    SpaceDto dto = new SpaceDto();
                    dto.setIdSpace(entity.getIdImpianto() != null
                            ? entity.getIdImpianto().toString()
                            : null);
                    dto.setDesSpace(entity.getDesImpianto() != null
                            ? entity.getDesImpianto()
                            : null);
                    dto.setAddressSpace(entity.getAddImpianto() != null
                            ? entity.getAddImpianto()
                            : null);
                    dto.setAmntRoom(entity.getRoomNo() != null
                            ? entity.getRoomNo().toString()
                            : null);
                    dto.setAmntDoor(entity.getDoorNo() != null
                            ? entity.getDoorNo().toString()
                            : null);
                    dto.setAmntWindow(entity.getWindowsNo() != null
                            ? entity.getWindowsNo().toString()
                            : null);
                    return dto;
                };
    }


}
