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
import static javafx.application.ConditionalFeature.FXML;
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
public class Salf22NotesViewController extends Switchable implements Initializable {
    
    @FXML
    private DatePicker picker;
    
    @FXML 
    private TextArea notes;
    
    //Collection class used to keep the data between the notes and the date
    private Map<LocalDate, String> data = new HashMap<>();
    
    NotesModel model = new NotesModel();
            
         
    public void updateNotes(){
        data.put(picker.getValue(), notes.getText());
    }
    
    public void exit(){
        save();
        Platform.exit();
    }
    
    //save notes entered while the application is active
    public void save(){
        try(ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("notes.data")))){
            stream.writeObject(data);
            System.out.println("Notes were successfully saved");
        } catch(Exception e){
            System.out.println("Failed to save: " + e);
        }
    }
    
    //Loads the notes that were previously saved even after the application is closed and re-opened
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
    
//    public void goHome(ActionEvent event) throws IOException{
//        Parent home = FXMLLoader.load(getClass().getResource("homePage.fxml"));
//        Scene homeScene = new Scene(home);
//        
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(homeScene);
//        window.show();
//    }
    
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        
        picker.valueProperty().addListener((o, oldDate, date) -> {
            notes.setText(data.getOrDefault(date, ""));
        });
        
        picker.setValue(LocalDate.now());
    }    
    
}
