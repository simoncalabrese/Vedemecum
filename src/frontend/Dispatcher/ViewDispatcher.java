package frontend.Dispatcher;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import javafx.stage.Stage;
import main.MainClass;

/**
 * Created by simon on 05/09/16.
 */
public class ViewDispatcher {

    static ViewDispatcher dispatcher = new ViewDispatcher();

    public static ViewDispatcher getDispatcher(){
        return dispatcher;
    }

    public void dispatch(String view){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getClassLoader().getResource(view));
            AnchorPane role = loader.load();
            Stage s = MainClass.getPrimaryStage();
            s.setScene(new Scene(role));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
