package api.dto;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

/**
 * Created by simon on 04/10/16.
 */
public class CardDto {

    private SimpleStringProperty idCard;
    private SimpleStringProperty headerCard;
    private SimpleStringProperty footerCard;
    private List<Integer> employeeDtos;
    private List<Integer> spaceDtos;
    private List<Integer> strumentationDtos;

    private List<EmployeeDto> employeeDtoList;
    private List<SpaceDto> spaceDtoList;
    private List<StrumentationDto> strumentationDtoList;

    public String getIdCard() {
        return idCard.get();
    }

    public SimpleStringProperty idCardProperty() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = new SimpleStringProperty(idCard);
    }

    public String getHeaderCard() {
        return headerCard.get();
    }

    public SimpleStringProperty headerCardProperty() {
        return headerCard;
    }

    public void setHeaderCard(String headerCard) {
        this.headerCard= new SimpleStringProperty(headerCard);
    }

    public String getFooterCard() {
        return footerCard.get();
    }

    public SimpleStringProperty footerCardProperty() {
        return footerCard;
    }

    public void setFooterCard(String footerCard) {
        this.footerCard= new SimpleStringProperty(footerCard);
    }

    public List<Integer> getEmployeeDtos() {
        return employeeDtos;
    }

    public void setEmployeeDtos(List<Integer> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }

    public List<Integer> getSpaceDtos() {
        return spaceDtos;
    }

    public void setSpaceDtos(List<Integer> spaceDtos) {
        this.spaceDtos = spaceDtos;
    }

    public List<Integer> getStrumentationDtos() {
        return strumentationDtos;
    }

    public void setStrumentationDtos(List<Integer> strumentationDtos) {
        this.strumentationDtos = strumentationDtos;
    }

    public List<EmployeeDto> getEmployeeDtoList() {
        return employeeDtoList;
    }

    public void setEmployeeDtoList(List<EmployeeDto> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }

    public List<SpaceDto> getSpaceDtoList() {
        return spaceDtoList;
    }

    public void setSpaceDtoList(List<SpaceDto> spaceDtoList) {
        this.spaceDtoList = spaceDtoList;
    }

    public List<StrumentationDto> getStrumentationDtoList() {
        return strumentationDtoList;
    }

    public void setStrumentationDtoList(List<StrumentationDto> strumentationDtoList) {
        this.strumentationDtoList = strumentationDtoList;
    }
}
