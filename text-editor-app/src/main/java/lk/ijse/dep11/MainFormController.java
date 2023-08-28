package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class MainFormController {

    public MenuItem btnNew;
    public HTMLEditor htmlEditor;
    public MenuItem btnClose;
    public MenuItem btnUserGuide;
    public MenuItem btnAbout;
    public MenuItem btnOpen;
    public AnchorPane root;
    File selectedFile;

    public void btnNewOnAction(ActionEvent actionEvent) throws IOException {

        AnchorPane root= FXMLLoader.load(StartController.class.getResource("/view/MainForm.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Text Editor");
        stage.centerOnScreen();
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {
            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure want to exit?", ButtonType.YES, ButtonType.NO).showAndWait();
            if(buttonType.get()==ButtonType.NO) windowEvent.consume();
        });
    }
    public void btnCloseOnAction(ActionEvent actionEvent) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure want to exit?", ButtonType.YES, ButtonType.NO).showAndWait();
        if(buttonType.get()==ButtonType.YES) System.exit(0);

    }

    public void btnUserGuideOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane root= FXMLLoader.load(getClass().getResource("/view/UserGuide.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);String htmlText = htmlEditor.getHtmlText();
        // Create a ClipboardContent object
        ClipboardContent content = new ClipboardContent();
        content.putHtml(htmlText);
        // Set the content to the clipboard
        Clipboard.getSystemClipboard().setContent(content);
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

    public void btnOpenOnAction(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("/"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File","*.txt"));
        File txtFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        Path path = Paths.get(txtFile.toURI());
        String text = Files.readString(path);
        htmlEditor.setHtmlText(text);
    }
    public void btnSaveOnAction(ActionEvent actionEvent) {

        if(selectedFile==null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("/"));
            selectedFile = fileChooser.showSaveDialog(root.getScene().getWindow());

        }
        save();
    }
    public void btnSaveAsOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("/"));
        selectedFile = fileChooser.showSaveDialog(root.getScene().getWindow());
        save();
    }
    public void save(){
        String textToWrite = htmlEditor.getHtmlText();
        if (selectedFile!=null && !textToWrite.isEmpty()) {
            String filePath = selectedFile.getAbsolutePath();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(textToWrite);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void btnCopyOnAction(ActionEvent actionEvent) {

        String htmlText = htmlEditor.getHtmlText();
        // Create a ClipboardContent object
        ClipboardContent content = new ClipboardContent();
        content.putHtml(htmlText);
        // Set the content to the clipboard
        Clipboard.getSystemClipboard().setContent(content);
    }

    public void btnCutOnAction(ActionEvent actionEvent) {
        String htmlText = htmlEditor.getHtmlText();
        htmlEditor.setHtmlText("");

        // Create a ClipboardContent object
        ClipboardContent content = new ClipboardContent();
        content.putHtml(htmlText);
        // Set the content to the clipboard
        Clipboard.getSystemClipboard().setContent(content);
    }

    public void btnPasteOnAction(ActionEvent actionEvent) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        if (clipboard.hasString()) {
            String plainText = clipboard.getString();
            String htmlText = "<p>" + plainText + "</p>";
            htmlEditor.setHtmlText(htmlText);
        }
    }
}


