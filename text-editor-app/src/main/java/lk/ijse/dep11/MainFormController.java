package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainFormController {

    public MenuItem btnNew;
    public HTMLEditor htmlEditor;
    public MenuItem btnClose;
    public MenuItem btnUserGuide;
    public MenuItem btnAbout;

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
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("User Guide");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnAboutOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane root= FXMLLoader.load(getClass().getResource("/view/About.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("About");

        stage.initStyle(StageStyle.TRANSPARENT);
        root.setBackground(Background.fill(Color.TRANSPARENT));
        scene.setFill(Color.TRANSPARENT);

        stage.centerOnScreen();
        stage.show();
    }
}
