package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {

    public MenuItem btnNew;
    public HTMLEditor htmlEditor;
    public MenuItem btnClose;
    public MenuItem btnUserGuide;

    public void btnNewOnAction(ActionEvent actionEvent) {
        htmlEditor.setHtmlText("");
    }
    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void btnUserGuideOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane root= FXMLLoader.load(getClass().getResource("/view/UserGuide.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("User Guide");
        stage.centerOnScreen();
        stage.show();
    }
}
