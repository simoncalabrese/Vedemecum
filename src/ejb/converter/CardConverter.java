package ejb.converter;


import api.dto.*;
import model.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simon on 31/08/16.
 */
public class CardConverter {

    public static class ToEntity {

    }

    public static class ToDto {
        public static SuperConverter<Card, CardDto> toCardDto =
                e -> {
                    CardDto dto = new CardDto();
                    dto.setIdCard(e.getIdScheda().toString());
                    dto.setHeaderCard(e.getHeader());
                    dto.setFooterCard(e.getBottom());
                    dto.setEmployeeDtoList(EmployeeConverter.ToDto.toEmployeeDto
                            .applyToList(e.getEmployees()));
                    dto.setStrumentationDtoList(StrumentationConverter.ToDto.toStrumentationDto
                            .applyToList(e.getStrumentations()));
                    dto.setSpaceDtoList(SpaceConverter.ToDto.toSpaceDto
                            .applyToList(e.getSpaces()));
                    return dto;

                };
        public static SuperConverter<List<Card>, List<CardDto>> toCardDtoId =
                elem -> {
                    List<CardDto> dtos = new ArrayList<>();
                    elem.forEach(e -> {
                        CardDto dto = new CardDto();
                        dto.setIdCard(e.getIdScheda().toString());
                        dto.setEmployeeDtos(EmployeeConverter.ToDto.toEmployeeDto
                                .applyToList(e.getEmployees())
                                .stream()
                                .map((employeeDto) -> Integer.valueOf(employeeDto.getIdDipedente()))
                                .collect(Collectors.toList()));
                        dto.setStrumentationDtos(StrumentationConverter.ToDto.toStrumentationDto
                                .applyToList(e.getStrumentations())
                                .stream()
                                .map((employeeDto) -> Integer.valueOf(employeeDto.getIdStrumentazione()))
                                .collect(Collectors.toList()));
                        dto.setSpaceDtos(SpaceConverter.ToDto.toSpaceDto
                                .applyToList(e.getSpaces())
                                .stream()
                                .map((employeeDto) -> Integer.valueOf(employeeDto.getIdSpace()))
                                .collect(Collectors.toList()));
                        dtos.add(dto);
                    });
                    return dtos;

                };

    }


}
