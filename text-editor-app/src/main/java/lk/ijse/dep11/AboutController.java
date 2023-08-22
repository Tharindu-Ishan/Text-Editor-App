package lk.ijse.dep11;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AboutController {


    public AnchorPane root;
    public ImageView imgRoot;

    public void rootOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void rootOnMouseMoved(MouseEvent mouseEvent) {


    }

    public void rootOnMouseDragged(MouseEvent mouseEvent) {
        imgRoot.setLayoutX(mouseEvent.getX()-imgRoot.getFitWidth()/2);
        imgRoot.setLayoutY(mouseEvent.getY()-imgRoot.getFitWidth()/2);
    }
}
