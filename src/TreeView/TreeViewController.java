package TreeView;

import MainWindow.BBA;
import MainWindow.MainWindowController;
import MainWindow.Teilbereich;
import Pdf.ErstellePDF;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;
import org.apache.pdfbox.debugger.ui.Tree;
import org.bouncycastle.tsp.TSPUtil;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;



public class TreeViewController implements Initializable {

    @FXML
    private AnchorPane anchorPaneTreeViewInhalt;

    @FXML
    public TreeView<String> treeViewBBA;

    @FXML
    private AnchorPane anchorPaneTableView;

    @FXML
    private StackPane stackPaneTableView;

    @FXML
    private AnchorPane anchorPaneTableViewBBA1;

    @FXML
    private AnchorPane anchorPaneTableViewBBA2;

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//
//    //Zaehler für die erstellten BBA, Zaehler entspricht der Zeile
//    int bbaZaehler = 0;
//
//    //Zaehler für die erstellten TB innerhalb eines BBA
//    int tbZaehler = 0;
//
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//    /**
//     * ArrayList um die im TreeView erstellten BBA's zu speichern
//     */
//   ArrayList<BBA> bbaListe = new ArrayList();
//
//    /**
//     * 2D-ArrayList für die Teilbereiche, die Zeile entspricht dem zugeordneten BBA
//      */
//    ArrayList<Teilbereich> tbListe = new ArrayList();
//
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

    public void initialize(URL url, ResourceBundle resourceBundle) {

//----------------------------------------------------------------------------------------------------------------------
        /**
         * TreeView (Anfangsausgabe) wird erstellt
         */
        TreeItem<String> rootItem = new TreeItem<>("NeuesProjekt");

        treeViewBBA.setRoot(rootItem);
        treeViewBBA.setShowRoot(false);
        rootItem.setExpanded(true);

        /**
         * Manuelles hinzufügen der TreeItems, da sie nach Namen (bba1) unterschieden werden sollen
         */
        TreeItem<String> bba1 = new TreeItem<>("Neuer BBA 1");
        TreeItem<String> bba2 = new TreeItem<>("Neuer BBA 2");
        TreeItem<String> bba3 = new TreeItem<>("Neuer BBA 3");
        TreeItem<String> bba4 = new TreeItem<>("Neuer BBA 4");
        TreeItem<String> bba5 = new TreeItem<>("Neuer BBA 5");

        rootItem.getChildren().addAll(bba1, bba2, bba3, bba4, bba5);

        //hinzufügen der TB zu BBA1
        TreeItem<String> tb_1_1 = new TreeItem<>("Neuer Teilbereich 1.1");
        TreeItem<String> tb_1_2 = new TreeItem<>("Neuer Teilbereich 1.2");
        TreeItem<String> tb_1_3 = new TreeItem<>("Neuer Teilbereich 1.3");
        TreeItem<String> tb_1_4 = new TreeItem<>("Neuer Teilbereich 1.4");
        TreeItem<String> tb_1_5 = new TreeItem<>("Neuer Teilbereich 1.5");

        bba1.getChildren().addAll(tb_1_1, tb_1_2, tb_1_3, tb_1_4, tb_1_5);

        //hinzufügen der TB zu BBA2
        TreeItem<String> tb_2_1 = new TreeItem<>("Neuer Teilbereich 2.1");
        TreeItem<String> tb_2_2 = new TreeItem<>("Neuer Teilbereich 2.2");
        TreeItem<String> tb_2_3 = new TreeItem<>("Neuer Teilbereich 2.3");
        TreeItem<String> tb_2_4 = new TreeItem<>("Neuer Teilbereich 2.4");
        TreeItem<String> tb_2_5 = new TreeItem<>("Neuer Teilbereich 2.5");

        bba2.getChildren().addAll(tb_2_1, tb_2_2, tb_2_3, tb_2_4, tb_2_5);

        //hinzufügen der TB zu BBA3
        TreeItem<String> tb_3_1 = new TreeItem<>("Neuer Teilbereich 3.1");
        TreeItem<String> tb_3_2 = new TreeItem<>("Neuer Teilbereich 3.2");
        TreeItem<String> tb_3_3 = new TreeItem<>("Neuer Teilbereich 3.3");
        TreeItem<String> tb_3_4 = new TreeItem<>("Neuer Teilbereich 3.4");
        TreeItem<String> tb_3_5 = new TreeItem<>("Neuer Teilbereich 3.5");

        bba3.getChildren().addAll(tb_3_1, tb_3_2, tb_3_3, tb_3_4, tb_3_5);

        //hinzufügen der TB zu BBA4
        TreeItem<String> tb_4_1 = new TreeItem<>("Neuer Teilbereich 4.1");
        TreeItem<String> tb_4_2 = new TreeItem<>("Neuer Teilbereich 4.2");
        TreeItem<String> tb_4_3 = new TreeItem<>("Neuer Teilbereich 4.3");
        TreeItem<String> tb_4_4 = new TreeItem<>("Neuer Teilbereich 4.4");
        TreeItem<String> tb_4_5 = new TreeItem<>("Neuer Teilbereich 4.5");

        bba4.getChildren().addAll(tb_4_1, tb_4_2, tb_4_3, tb_4_4, tb_4_5);

        //hinzufügen der TB zu BBA5
        TreeItem<String> tb_5_1 = new TreeItem<>("Neuer Teilbereich 5.1");
        TreeItem<String> tb_5_2 = new TreeItem<>("Neuer Teilbereich 5.2");
        TreeItem<String> tb_5_3 = new TreeItem<>("Neuer Teilbereich 5.3");
        TreeItem<String> tb_5_4 = new TreeItem<>("Neuer Teilbereich 5.4");
        TreeItem<String> tb_5_5 = new TreeItem<>("Neuer Teilbereich 5.5");

        bba5.getChildren().addAll(tb_5_1, tb_5_2, tb_5_3, tb_5_4, tb_5_5);
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
        /**
         * Anfangsausgabe der TableViews wird festgelegt
         * TableView für BBA1 ist sichtbar
         */
        anchorPaneTableViewBBA1.setVisible(true);
        anchorPaneTableViewBBA2.setVisible(false);

        /**
         *
         */
        treeViewBBA.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // BBA 1 TableView wird sichtbar
            if (newValue != null && newValue != oldValue && newValue.equals(bba1)) {
                anchorPaneTableViewBBA1.setVisible(true);
                anchorPaneTableViewBBA2.setVisible(false);
            }

            // BBA 2 Tableview wird sichtbar
            else if (newValue != null && newValue != oldValue && newValue.equals(bba2)) {
                anchorPaneTableViewBBA1.setVisible(false);
                anchorPaneTableViewBBA2.setVisible(true);
            }
        });


        treeViewBBA.setEditable(true);
        treeViewBBA.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new TextFieldTreeCellImpl();
//                return new RenameMenuTreeCell();
            }
        });
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
    /**
     * Klasse um die Namensänderung und
     * das Hinzufügen neuer TreeItems zu ermöglichen
     */
    private final class TextFieldTreeCellImpl extends TreeCell<String> {

        private TextField textField;
        private ContextMenu contextMenu = new ContextMenu();

        public TextFieldTreeCellImpl() {

            /**
             * erstellen des ContextMenus
             */

            MenuItem entfernenMenu = new MenuItem("Entfernen");
            contextMenu.getItems().addAll(entfernenMenu);
            treeViewBBA.setContextMenu(contextMenu);

            //entfernt den gewählten BBA oder TB aus der TreeView
            entfernenMenu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    //für das Löschen aus der TreeView
                    TreeItem entfernenItem = (TreeItem)treeViewBBA.getSelectionModel().getSelectedItem();
                    boolean remove = entfernenItem.getParent().getChildren().remove(entfernenItem);
                }
            });
        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText((String) getItem());
            setGraphic(getTreeItem().getGraphic());
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(getTreeItem().getGraphic());
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setOnKeyReleased(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(textField.getText());
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
}
