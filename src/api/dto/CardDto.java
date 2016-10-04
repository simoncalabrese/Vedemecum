package api.dto;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by simon on 04/10/16.
 */
public class CardDto {

    private SimpleStringProperty idCard;
    private SimpleStringProperty headerCard;
    private SimpleStringProperty footerCard;

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
}
