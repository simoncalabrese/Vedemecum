package ejb.converter;


import api.dto.EmployeeDto;
import api.dto.RoleDto;
import api.utils.UtilDate;
import model.entity.Employee;

import java.util.List;

/**
 * Created by simon on 31/08/16.
 */
public class EmployeeConverter {

    public static class ToEntity {
        public static BiSuperConverter<EmployeeDto, RoleDto, Employee> toEmployeeEntity =
                (dto, dto1) -> {
                    Employee employee = new Employee();
                    employee.setIdDipedente(dto.getIdDipedente() != null
                            ? Integer.valueOf(dto.getIdDipedente())
                            : null);
                    employee.setNomeDipendente(dto.nomeDipendenteProperty().get());
                    employee.setCognomeDipendente(dto.cognomeDipendenteProperty().get());
                    employee.setSessoDipendente(dto.sessoDipendenteProperty().get());
                    employee.setDtNascita(UtilDate.toDate(dto.dtNascitaProperty().getValue()));
                    employee.setCodFiscale(dto.codFiscaleProperty().get());
                    employee.setTelephone(dto.telephoneProperty().get());
                    employee.setAddress(dto.addressProperty().get());
                    employee.setEmail(dto.emailProperty().get());
                    employee.setRole(RoleConverter.ToEntity.toMansioneEntity.apply(dto1));
                    return employee;
                };

    }

    public static class ToDto {
        public static SuperConverter<Employee, EmployeeDto> toEmployeeDto =
                entity -> {
                    EmployeeDto dto = new EmployeeDto();
                    dto.setIdDipedente(entity.getIdDipedente().toString());
                    dto.setNomeDipendente(entity.getNomeDipendente());
                    dto.setCognomeDipendente(entity.getCognomeDipendente());
                    dto.setSessoDipendente(entity.getSessoDipendente());
                    dto.setDtNascita(UtilDate.toString(entity.getDtNascita()));
                    dto.setCodFiscale(entity.getCodFiscale());
                    dto.setTelephone(entity.getTelephone());
                    dto.setAddress(entity.getAddress());
                    dto.setEmail(entity.getEmail());
                    dto.setRole(entity.getRole().getCodRole());
                    return dto;
                };
    }


}
