package frontend.Dispatcher;

import api.utils.Enumerators;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import javafx.stage.Modality;
import javafx.stage.Stage;
import main.MainClass;

/**
 * Created by simon on 05/09/16.
 */
public class ViewDispatcher {

    static ViewDispatcher dispatcher = new ViewDispatcher();


    public static ViewDispatcher getDispatcher() {
        return dispatcher;
    }

    public void dispatch(String view) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getClassLoader().getResource(view));
            AnchorPane pane = loader.load();
            MainClass.getPrimaryStage().setScene(new Scene(pane));
            MainClass.getPrimaryStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void alert(Enumerators.Alert msg, String variable) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("System Client Error");
        alert.setHeaderText(msg.getHead());
        alert.setContentText(msg.getBody() + (variable != null ? variable : ""));

        alert.showAndWait();
    }


    public void dialog(String view) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getClassLoader().getResource((view)));
            AnchorPane pane = loader.load();
            Stage dialogStage = MainClass.getDialogStage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainClass.getPrimaryStage());
            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
