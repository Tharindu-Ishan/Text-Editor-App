package lk.ijse.dep11;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AboutController {


    public ImageView imgRoot;
    public AnchorPane rootAbout;


    public void rootOnMouseDragged(MouseEvent mouseEvent) {
        rootAbout.setLayoutX(mouseEvent.getX()-rootAbout.getWidth()/2);
        rootAbout.setLayoutY(mouseEvent.getY()-rootAbout.getHeight()/2);


    }
}
