package lk.ijse.dep11;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class StartController {
    public Button btn;
    public ImageView img;
    public AnchorPane rootStart;

    public static void initializ(Stage p) throws IOException, InterruptedException {


        AnchorPane root= FXMLLoader.load(StartController.class.getResource("/view/MainForm.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Text Editor");
        stage.centerOnScreen();
        stage.setOnCloseRequest(windowEvent -> {
            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure want to exit?", ButtonType.YES, ButtonType.NO).showAndWait();
            if(buttonType.get()==ButtonType.NO) windowEvent.consume();
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), event -> {
            p.close(); // Close the initial window
            stage.show(); // Show the new window
        }));
        timeline.setCycleCount(1); // Run the timeline once

        // Show the initial window and start the timeline
        p.show();
        timeline.play();



    }


}
