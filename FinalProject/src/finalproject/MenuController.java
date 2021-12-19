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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Admin
 */

//Switching between Scenes
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
    private void handleButtonAction(ActionEvent event) throws Exception{
        Stage stage= null;
        Parent root= null;
        if(event.getSource() == btn_Dept){ 
            System.out.println("You are in Department fxml");
            stage = (Stage) btn_Dept.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("DepartmentMenu.fxml"));
        }
        if(event.getSource() == btn_Staff){
            System.out.println("You are in Staff fxml");
            stage = (Stage) btn_Staff.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StaffMenu.fxml"));
        }
        if(event.getSource() == btn_Teacher){
            System.out.println("You are in Teacher fxml");
            stage = (Stage) btn_Teacher.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("TeacherMenu.fxml"));
        }
        if(event.getSource() == btn_Student){
            System.out.println("You are in Student fxml");
            stage = (Stage) btn_Student.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("StudentMenu.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
