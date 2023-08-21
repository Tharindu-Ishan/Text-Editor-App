package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.web.HTMLEditor;

public class MainFormController {

    public MenuItem btnNew;
    public HTMLEditor htmlEditor;
    public MenuItem btnClose;

    public void btnNewOnAction(ActionEvent actionEvent) {
        htmlEditor.setHtmlText("");
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
