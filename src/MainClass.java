/**
 * Created by simon on 03/09/16.
 */

import frontend.RoleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private RoleController roleController = new RoleController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("App");
        initRootLayout();
        showRoles();
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("frontend/Root.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRoles() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("frontend/RoleView.fxml"));
            AnchorPane role = loader.load();
            rootLayout.setCenter(role);
            RoleController roleController = new RoleController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
