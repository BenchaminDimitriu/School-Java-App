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
public class DepartmentMenuController implements Initializable {

    @FXML
    private TableView<?> tbl_Teacher;
    @FXML
    private TableColumn<?, ?> cln_Teach_ID;
    @FXML
    private TableColumn<?, ?> cln_Teach_Name;
    @FXML
    private TableView<?> tbl_Student;
    @FXML
    private TableColumn<?, ?> cln_Stu_ID;
    @FXML
    private TableColumn<?, ?> cln_Stu_Name;
    @FXML
    private TableView<?> tbl_Staff;
    @FXML
    private TableColumn<?, ?> cln_Staff_ID;
    @FXML
    private TableColumn<?, ?> cln_Staff_Name;
    @FXML
    private TextField tf_dept_ID;
    @FXML
    private Button btn_Dept_ID;
    @FXML
    private TableView<?> tbl_Department;
    @FXML
    private TableColumn<?, ?> cln_Dept_ID;
    @FXML
    private TableColumn<?, ?> cln_Dept_Desc;
    @FXML
    private Button btn_Load;
    @FXML
    private Button btn_Back_To_Menu;

    public void BufferedReaderFile(FileReader fileReader){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(
            "C:\\Users\\Admin\\Documents\\GitHub\\Final-Project\\FinalProject\\Department.txt"));
        }catch(FileNotFoundException lostfile){
            System.out.println(lostfile.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void handleMenuButtonAction(ActionEvent event) throws Exception{
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
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception{
        
    }
}
