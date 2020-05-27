/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salf22final;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Spencer Laird
 */

//this class will extend the main notes class, becoming a subclass of it.
public class GroceriesFXMLController extends Salf22NotesViewController implements Initializable, NotesInterface{
 @FXML
    private DatePicker picker;
    
    @FXML 
    private TextArea notes;
    
    private Map<LocalDate, String> data = new HashMap<>();
    //NotesModel model = new NotesModel();
            
    public void saveNotes(){
        data.put(picker.getValue(), notes.getText());
    }
    
    @Override
    public void exit(){
        save();
        Platform.exit();
    }
    
    @Override
    public void save(){
        try(ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("notes.data")))){
            stream.writeObject(data);
            System.out.println("Notes were successfully saved");
        } catch(Exception e){
            System.out.println("Failed to save: " + e);
        }
    }
    
    @Override
    public void load(){
        Path file = Paths.get("notes.data");
        
        if(Files.exists(file)){
            try(ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(file))) {
                data = (Map<LocalDate, String>) stream.readObject();
                System.out.println("Loaded!");
            } catch(Exception e){
                System.out.println("Failed to load: " + e);
             }
        }
    }
    
    private void getHome(ActionEvent event) throws IOException{
         Parent groceryScene = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene grocery = new Scene(groceryScene);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(grocery);
        window.show();
    }
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         load();
        
        picker.valueProperty().addListener((o, oldDate, date) -> {
            notes.setText(data.getOrDefault(date, ""));
        });
        
        picker.setValue(LocalDate.now());
    }    
    
}
