package model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by simon on 01/09/16.
 */
@Entity
@Table(
        name = "ANAG_IMPIANTI"
)
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "ID_IMPIANTO",
            nullable = false
    )
    private Integer idImpianto;

    @Column(
            name = "DES_IMPIANTO",
            nullable = false
    )
    private String desImpianto;

    @Column(
            name = "IND_IMPIANTO"
    )
    private String addImpianto;

    @Column(
            name = "AMNT_STANZE"
    )
    private Integer roomNo;

    @Column(
            name = "AMNT_PORTE"
    )
    private Integer doorNo;

    @Column(
            name = "AMNT_FINESTRE"
    )
    private Integer windowsNo;

    @ManyToOne
    @JoinColumn(
            name = "CARD_FK"
    )
    private Card card;


    @OneToMany(
            mappedBy = "space"
    )
    private List<SpaceEmployee> spaceEmployees;

    public Integer getIdImpianto() {
        return idImpianto;
    }

    public void setIdImpianto(Integer idImpianto) {
        this.idImpianto = idImpianto;
    }

    public String getDesImpianto() {
        return desImpianto;
    }

    public void setDesImpianto(String desImpianto) {
        this.desImpianto = desImpianto;
    }

    public String getAddImpianto() {
        return addImpianto;
    }

    public void setAddImpianto(String addImpianto) {
        this.addImpianto = addImpianto;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(Integer doorNo) {
        this.doorNo = doorNo;
    }

    public Integer getWindowsNo() {
        return windowsNo;
    }

    public void setWindowsNo(Integer windowsNo) {
        this.windowsNo = windowsNo;
    }

    public List<SpaceEmployee> getSpaceEmployees() {
        return spaceEmployees;
    }

    public void setSpaceEmployees(List<SpaceEmployee> spaceEmployees) {
        this.spaceEmployees = spaceEmployees;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
