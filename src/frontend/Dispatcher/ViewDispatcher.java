package frontend.Dispatcher;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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
            AnchorPane pane = loader.load();
            MainClass.getPrimaryStage().setScene(new Scene(pane));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
