/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class JavaFXApplication2 extends Application {

    TextArea ta;
    Menu file;
    Menu edit;
    Menu help;
    BorderPane pane;
    MenuBar menubar;
    SeparatorMenuItem sp1;
    SeparatorMenuItem sp2;
    SeparatorMenuItem sp3;
    MenuItem openitem = new MenuItem("Open..");
    MenuItem newitem = new MenuItem("New");
    MenuItem saveitem = new MenuItem("Save");
    MenuItem exititem = new MenuItem("Exit");
    MenuItem undoitem = new MenuItem("Undo");
    MenuItem cutitem = new MenuItem("Cut");
    MenuItem copyitem = new MenuItem("Copy");
    MenuItem pasteitem = new MenuItem("Paste");
    MenuItem deleteitem = new MenuItem("Delete");
    MenuItem saitem = new MenuItem("Select All");
    MenuItem about = new MenuItem("About Notepad..");

    @Override
    public void init() throws Exception {

        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        ta = new TextArea();
        pane = new BorderPane();
        menubar = new MenuBar();
        ///////////////////////////////////
        file = new Menu("File");
        sp1 = new SeparatorMenuItem();
        newitem.setAccelerator(KeyCombination.keyCombination("Alt+f"));
        openitem.setAccelerator(KeyCombination.keyCombination("Alt+o"));
        saveitem.setAccelerator(KeyCombination.keyCombination("Alt+s"));
        exititem.setAccelerator(KeyCombination.keyCombination("Alt+e"));
        file.getItems().addAll(newitem, openitem, saveitem, exititem);
        file.getItems().add(1, sp1);
        ///////////////////////////////
        edit = new Menu("Edit");
        sp2 = new SeparatorMenuItem();
        sp3 = new SeparatorMenuItem();
        undoitem.setAccelerator(KeyCombination.keyCombination("Alt+u"));
        cutitem.setAccelerator(KeyCombination.keyCombination("Alt+x"));
        copyitem.setAccelerator(KeyCombination.keyCombination("Alt+c"));
        pasteitem.setAccelerator(KeyCombination.keyCombination("Alt+v"));
        deleteitem.setAccelerator(KeyCombination.keyCombination("Alt+d"));
        saitem.setAccelerator(KeyCombination.keyCombination("Alt+a"));
        edit.getItems().addAll(undoitem, cutitem, copyitem, pasteitem, deleteitem, saitem);
        edit.getItems().add(3, sp2);
        edit.getItems().add(5, sp3);
        /////////////////////////////
        help = new Menu("Help");
        help.getItems().addAll(about);
        /////////////////////////////
        menubar.getMenus().addAll(file, edit, help);
        ta = new TextArea();
        pane.setTop(menubar);
        pane.setCenter(ta);
        /////////////////////////////

    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(pane, 300, 400);

        primaryStage.setTitle("This is mayoy's Notepad");
        primaryStage.setScene(scene);
        //////////////////////////////////
        openitem.setOnAction((ActionEvent event) -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("Open a File");
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("Java", "*.java"));
            fc.showOpenDialog(primaryStage);
        });
        saveitem.setOnAction((ActionEvent event) -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("Save As");
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text", "*.txt"),
                    new FileChooser.ExtensionFilter("Java", "*.java"));
            fc.showSaveDialog(primaryStage);

        });
        exititem.setOnAction((ActionEvent event) -> {
            System.exit(0);
            primaryStage.close();
        });
        ////////////////////////////////////////
        newitem.setOnAction((ActionEvent event) -> {
            ta.clear();
        });
        copyitem.setOnAction((ActionEvent event) -> {
            ta.copy();
        });
        pasteitem.setOnAction((ActionEvent event) -> {
            ta.paste();
        });
        deleteitem.setOnAction((ActionEvent event) -> {
            ta.deletePreviousChar();
        });
        saitem.setOnAction((ActionEvent event) -> {
            ta.selectAll();
        });
        undoitem.setOnAction((ActionEvent event) -> {
            ta.undo();
        });
        ////////////////////////////////
        about.setOnAction((ActionEvent event) -> {
         Alert a = new Alert(AlertType.NONE);
         a.setAlertType(AlertType.INFORMATION);
         a.setContentText("This is mai's Notepad v101");
         a.show();
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
