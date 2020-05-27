/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salf22final;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Spencer Laird
 */
public class HomePageController extends Switchable implements Initializable {

    @FXML
    AnchorPane rootPane;
    /**
     * Initializes the controller class.
     */
    
     private Stage stage; 
    private Scene page1Scene;
    private Scene page2Scene; 
    private GroceriesFXMLController page2Controller; 
    
    
      public void exit(){
        //page2Controller.save();
        //retailController.save();
        Platform.exit();
    }
      
//      @FXML
//      public void loadSecond(ActionEvent event) throws IOException{
////          Switchable.switchTo("groceriesFXML", stage);
//        Parent groceryScene = FXMLLoader.load(getClass().getResource("groceriesFXML.fxml"));
//        Scene grocery = new Scene(groceryScene);
//        
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(grocery);
//        window.show();
//      }
//      
//      @FXML 
//      public void loadRetail(){
//          Switchable.switchTo("salf22NotesView");
//      }
      
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
