package api.dto;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by simon on 05/09/16.
 */
public class SpaceDto {

    private StringProperty idSpace;

    private StringProperty desSpace;

    private StringProperty addressSpace;

    private StringProperty amntRoom;

    private StringProperty amntDoor;

    private StringProperty amntWindow;

    public String getIdSpace() {
        return idSpace.get();
    }

    public StringProperty idSpaceProperty() {
        return idSpace;
    }

    public void setIdSpace(String idSpace) {
        this.idSpace = new SimpleStringProperty(idSpace);
    }

    public String getDesSpace() {
        return desSpace.get();
    }

    public StringProperty desSpaceProperty() {
        return desSpace;
    }

    public void setDesSpace(String desSpace) {
        this.desSpace = new SimpleStringProperty(desSpace);
    }

    public String getAddressSpace() {
        return addressSpace.get();
    }

    public StringProperty addressSpaceProperty() {
        return addressSpace;
    }

    public void setAddressSpace(String addressSpace) {
        this.addressSpace = new SimpleStringProperty(addressSpace);
    }

    public String getAmntRoom() {
        return amntRoom.get();
    }

    public StringProperty amntRoomProperty() {
        return amntRoom;
    }

    public void setAmntRoom(String amntRoom) {
        this.amntRoom = new SimpleStringProperty(amntRoom);
    }

    public String getAmntDoor() {
        return amntDoor.get();
    }

    public StringProperty amntDoorProperty() {
        return amntDoor;
    }

    public void setAmntDoor(String amntDoor) {
        this.amntDoor = new SimpleStringProperty(amntDoor);
    }

    public String getAmntWindow() {
        return amntWindow.get();
    }

    public StringProperty amntWindowProperty() {
        return amntWindow;
    }

    public void setAmntWindow(String amntWindow) {
        this.amntWindow = new SimpleStringProperty(amntWindow);
    }
}
