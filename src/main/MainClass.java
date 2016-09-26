package main; /**
 * Created by simon on 03/09/16.
 */

import api.utils.Enumerators;
import frontend.Dispatcher.ViewDispatcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {

    private static Stage primaryStage;
    private AnchorPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        MainClass.primaryStage = primaryStage;
        MainClass.primaryStage.setTitle("App");
        initRootLayout();
        ViewDispatcher.getDispatcher().dispatch(Enumerators.viewsPath.LOGIN.getPath());
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getClassLoader().getResource("frontend/Root.fxml"));
            rootLayout = loader.load();
            primaryStage.setScene(new Scene(rootLayout));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
