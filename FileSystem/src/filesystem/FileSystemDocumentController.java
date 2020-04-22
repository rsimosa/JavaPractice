/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 *
 * @author NEDL
 */
public class FileSystemDocumentController implements Initializable {

    FileSystemModel model = new FileSystemModel();

    @FXML
    private TreeView<Variables> treeView;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;

    TextInputDialog tid = new TextInputDialog();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            model.readJSON();

            treeView.setCellFactory((TreeView<Variables> tv) -> new TreeCell<Variables>() {

                @Override
                protected void updateItem(Variables item, boolean empty) {
                    super.updateItem(item, empty);

                    setText((empty || item == null) ? "" : item.getName());
                }

            });
            treeView.setShowRoot(false);

            treeView.setRoot(model.createTree());

        } catch (Exception e) {

            e.printStackTrace();
        }
        model.writeJSON();
    }

    @FXML
    private void mouseEvent(ActionEvent event) {

        TreeItem<Variables> selected = treeView.getSelectionModel().getSelectedItem();
        Variables document = selected.getValue();

        if (event.getSource() == deleteButton) {

            model.delete(document, selected);
        }

        if (event.getSource() == addButton) {
            tid.setTitle("Create new File");
            tid.setHeaderText("Input Folder Name");
            Optional<String> name = tid.showAndWait();

            model.create(name.get(), document.folderId);
            treeView.setRoot(model.createTree());

        }
    }
}
