package ejb.utils;

/**
 * Created by simon on 05/09/16.
 */
public class Enumerators {

    public enum viewsPath {
        LOGIN("frontend/LoginView.fxml"),
        HOMEPAGE("frontend/HomePage.fxml"),
        ROLE("frontend/RoleView.fxml");


        private String path;

        viewsPath(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
}
