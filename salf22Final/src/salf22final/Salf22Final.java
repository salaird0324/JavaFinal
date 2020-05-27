/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salf22final;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Spencer Laird
 */
public class Salf22Final extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
//       FXMLLoader retailLoader = new FXMLLoader(getClass().getResource("groceriesFXML.fxml"));
//      
//       Parent root = retailLoader.load();
//       
//       Scene scene1 = new Scene(root);
//       
////       
////   
////       
//      primaryStage.setOnCloseRequest(e -> {
//           e.consume();
//           retailLoader.<HomePageController>getController().exit();
//       });
//        primaryStage.setScene(new Scene(root));
//      primaryStage.setScene(scene1);
//      
//       primaryStage.show();

 HBox root = new HBox();
        root.setPrefSize(600, 400);
        root.setAlignment(Pos.CENTER);
        Text message = new Text("This is a failure!");
        message.setFont(Font.font(STYLESHEET_MODENA, 32));
        root.getChildren().add(message);
        
        // create Scene and init UI to show failure in case switch fails
        Scene scene = new Scene(root);
        FXMLLoader retailLoader = new FXMLLoader(getClass().getResource("salf22NotesView.fxml"));
        Parent par = retailLoader.load();
        Switchable.scene = scene; 
       // Switchable.switchTo("homePage");
        Scene scene1 = new Scene(par);
        //Switchable.scene = scene1;
//         primaryStage.setOnCloseRequest(e -> {
//           e.consume();
//           retailLoader.<Salf22NotesViewController>getController().exit();
//       });
          
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
