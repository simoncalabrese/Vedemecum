package api.dto;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by simon on 05/09/16.
 */
public class StrumentationDto {

    private StringProperty idStrumentazione;

    private StringProperty desStrumentazione;

    private StringProperty modelloStrumentazione;

    private StringProperty marcaStrumentazione;

    private StringProperty pezzi;

    private StringProperty dtAcquisto;

    public String getIdStrumentazione() {
        return idStrumentazione.get();
    }

    public StringProperty idStrumentazioneProperty() {
        return idStrumentazione;
    }

    public void setIdStrumentazione(String idStrumentazione) {
        this.idStrumentazione = new SimpleStringProperty(idStrumentazione);
    }

    public String getDesStrumentazione() {
        return desStrumentazione.get();
    }

    public StringProperty desStrumentazioneProperty() {
        return desStrumentazione;
    }

    public void setDesStrumentazione(String desStrumentazione) {
        this.desStrumentazione= new SimpleStringProperty(desStrumentazione);
    }

    public String getModelloStrumentazione() {
        return modelloStrumentazione.get();
    }

    public StringProperty modelloStrumentazioneProperty() {
        return modelloStrumentazione;
    }

    public void setModelloStrumentazione(String modelloStrumentazione) {
        this.modelloStrumentazione= new SimpleStringProperty(modelloStrumentazione);
    }

    public String getMarcaStrumentazione() {
        return marcaStrumentazione.get();
    }

    public StringProperty marcaStrumentazioneProperty() {
        return marcaStrumentazione;
    }

    public void setMarcaStrumentazione(String marcaStrumentazione) {
        this.marcaStrumentazione= new SimpleStringProperty(marcaStrumentazione);
    }

    public String getPezzi() {
        return pezzi.get();
    }

    public StringProperty pezziProperty() {
        return pezzi;
    }

    public void setPezzi(String pezzi) {
        this.pezzi= new SimpleStringProperty(pezzi);
    }

    public String getDtAcquisto() {
        return dtAcquisto.get();
    }

    public StringProperty dtAcquistoProperty() {
        return dtAcquisto;
    }

    public void setDtAcquisto(String dtAcquisto) {
        this.dtAcquisto= new SimpleStringProperty(dtAcquisto);
    }
}
