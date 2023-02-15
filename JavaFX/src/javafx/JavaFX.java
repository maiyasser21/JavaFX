/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafx;

import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.scene.effect.Reflection;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author DELL
 */
public class JavaFX extends Application {
    Text t;
    Rectangle r;
    StackPane root;
    Reflection ref;

    @Override
    public void init() throws Exception {
        
       super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        t=new Text("Hello World T^T");
        t.setId("Text");
        r =new Rectangle(0,0,301,250);
        r.setId("Rect");
        ref= new Reflection();
        ref.setFraction(0.8);
        t.setEffect(ref);
        
//        t.setStyle("-fx-fill:red;" + "-fx-font-size:40;");
//       
//       r.setStyle("-fx-fill: linear-gradient(rgba(0,101,101,1), rgba(0,101,101,1), rgba(101,101,101,1));");
//        
         root = new StackPane();
         root.getChildren().add(r);
         root.getChildren().add(t);
         
       
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = new Scene(root, 300, 250);
       scene.getStylesheets().add(getClass().getResource("GUI.css").toString());
        primaryStage.setTitle("Mai Yasser");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
       Application.launch(args);
    }
    
}
