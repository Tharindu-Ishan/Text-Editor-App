package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.web.HTMLEditor;

public class MainFormController {

    public MenuItem btnNew;
    public HTMLEditor htmlEditor;

    public void btnNewOnAction(ActionEvent actionEvent) {
        htmlEditor.setHtmlText("");
    }
}
