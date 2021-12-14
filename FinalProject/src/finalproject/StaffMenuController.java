/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class StaffMenuController implements Initializable {

    @FXML
    private TextField tf_ID;
    @FXML
    private TextField tf_Name;
    @FXML
    private TextField tf_Age;
    @FXML
    private TextField tf_Gender;
    @FXML
    private TextField tf_Duty;
    @FXML
    private TextField tf_Workload;
    @FXML
    private Button btn_Search;
    @FXML
    private Button btn_Assign_Dept;
    @FXML
    private Button btn_Load;
    @FXML
    private Button btn_Add;
    @FXML
    private TableView<?> tbl_Staff;
    @FXML
    private TableColumn<?, ?> cln_ID;
    @FXML
    private TableColumn<?, ?> cln_Name;
    @FXML
    private TableColumn<?, ?> cln_Age;
    @FXML
    private TableColumn<?, ?> cln_Gender;
    @FXML
    private TableColumn<?, ?> cln_Duty;
    @FXML
    private TableColumn<?, ?> cln_Workload;
    @FXML
    private Button btn_Compute_Payroll;
    @FXML
    private TextField tf_Compute_Payroll;
    @FXML
    private TextField tf_Dept_ID;
    @FXML
    private TableColumn<?, ?> cln_Dept_ID;
    @FXML
    private Button btn_Back_To_Menu;

    public void BufferedReaderFile(FileReader fileReader){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(
            "C:\\Users\\Admin\\Documents\\GitHub\\Final-Project\\FinalProject\\Staff.txt"));
        }catch(FileNotFoundException lostfile){
            System.out.println(lostfile.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception{
        Stage stage= null;
        Parent root= null;
        if(event.getSource() == btn_Back_To_Menu){ 
            System.out.println("You are in Menu fxml");
            stage = (Stage) btn_Back_To_Menu.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 
    
}
