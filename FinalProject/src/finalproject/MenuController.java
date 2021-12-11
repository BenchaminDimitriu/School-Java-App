/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MenuController implements Initializable {

    @FXML
    private Button btn_Dept;
    @FXML
    private Button btn_Staff;
    @FXML
    private Button btn_Teacher;
    @FXML
    private Button btn_Student;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btn_Dept) {
            
        }
        if(event.getSource() == btn_Staff){
        
        }
        if(event.getSource() == btn_Teacher){
            
        }
        if(event.getSource() == btn_Student){
            
        }
    }
    
}
