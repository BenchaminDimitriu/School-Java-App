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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Staff> tbl_Staff;
    @FXML
    private TableColumn<Staff, Integer> cln_ID;
    @FXML
    private TableColumn<Staff, String> cln_Name;
    @FXML
    private TableColumn<Staff,Integer> cln_Age;
    @FXML
    private TableColumn<Staff,String> cln_Gender;
    @FXML
    private TableColumn<Staff, String> cln_Duty;
    @FXML
    private TableColumn<Staff,Integer> cln_Workload;
    @FXML
    private Button btn_Compute_Payroll;
    @FXML
    private TextField tf_Compute_Payroll;
    @FXML
    private TextField tf_Dept_ID;
    @FXML
    private TableColumn<Staff,Integer> cln_Dept_ID;
    @FXML
    private Button btn_Back_To_Menu;
    
    private FileReader filereader;
    
    public static ObservableList<Staff> StaffL = FXCollections.observableArrayList();
    
        public void getStaff(ObservableList<Staff> arr){
        cln_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cln_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cln_Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        cln_Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        cln_Duty.setCellValueFactory(new PropertyValueFactory<>("Duty"));
        cln_Workload.setCellValueFactory(new PropertyValueFactory<>("Workload"));
        cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("dept_ID"));
        tbl_Staff.setItems(arr);
    }
    
    public void getStaffList(){
        Staff Sf = new Staff(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
        tf_Duty.getText(),Integer.parseInt(tf_Workload.getText()),Integer.parseInt(tf_Dept_ID.getText()));
        StaffL.add(Sf);
    }
    public void saveStaff(){
        getStaffList();
        getStaff(StaffL);
    }
        
    public void BufferedReaderFile(FileReader fileReader) throws IOException{
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Documents\\GitHub\\Final-Project\\FinalProject\\Staff.txt"));
            //id,name,age,gender,duty,workload,department_id
            String line = reader.readLine();
             while(line!=null){
                System.out.println(line);
                Staff newStaff = new Staff();
                String Mydata[]  = line.split(",");
                newStaff.setID(Integer.parseInt(Mydata[0]));
                newStaff.setName(Mydata[1]);
                newStaff.setAge(Integer.parseInt(Mydata[2]));
                newStaff.setGender(Mydata[3]);
                newStaff.setDuty(Mydata[4]);
                newStaff.setWorkload(Integer.parseInt(Mydata[5]));
                 for(String input: Mydata){
                    System.out.println( "Input: " + input);
                }
                line = reader.readLine();
                StaffL.add(newStaff);
             }
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
                if(event.getSource() == btn_Load){
            InitiliazeStaff(StaffL);
        }
    } 
    private void InitiliazeStaff(ObservableList<Staff> arr) throws IOException{
    BufferedReaderFile(filereader);
    cln_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    cln_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
    cln_Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
    cln_Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
    cln_Duty.setCellValueFactory(new PropertyValueFactory<>("Duty"));
    cln_Workload.setCellValueFactory(new PropertyValueFactory<>("Workload"));
    cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("dept_ID"));
    tbl_Staff.setItems(arr);
    }
}
