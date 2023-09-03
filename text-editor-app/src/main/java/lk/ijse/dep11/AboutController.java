package lk.ijse.dep11;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AboutController {


    public ImageView imgRoot;
    public AnchorPane rootAbout;

    public void initialize(){

    }


//    public void rootOnMouseDragged(MouseEvent mouseEvent) {
//        rootAbout.setLayoutX(imgRoot.getScaleX()-rootAbout.getWidth()/2);
//        rootAbout.setLayoutY(mouseEvent.getY()-rootAbout.getHeight()/2);
//
//    }

    public void rootOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void rootOnMouseMoved(MouseEvent mouseEvent) {

    }

    public void imgRootOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void imgRootOnMouseDragged(MouseEvent mouseEvent) {

        Stage stage=(Stage)rootAbout.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX()-x);
        stage.setY(mouseEvent.getScreenY()-y);

    }

    public void imgRootOnMousePressed(MouseEvent mouseEvent) {
        x=mouseEvent.getSceneX();
        y=mouseEvent.getSceneY();
    }
    double x;
    double y;

    public void rootOnMouseDragged(MouseEvent mouseEvent) {

    }
}
