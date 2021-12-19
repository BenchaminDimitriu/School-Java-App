/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.StudentMenuController.StList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
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
        cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("Dept_ID"));
        tbl_Staff.setItems(arr);
    }
    
    public void getStaffList() throws IOException{
        Staff Sf = new Staff(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
        tf_Duty.getText(),Integer.parseInt(tf_Workload.getText()),Integer.parseInt(tf_Dept_ID.getText()));
        //StaffL.add(Sf);
        boolean found = false;
        for (int i = 0; i < StaffL.size(); i++) {
            if(Sf.getID() == StaffL.get(i).getID()){
                found = true;
                System.out.println("Index already exists!");
                break;
            }
        }
        if (found == false){
            StaffL.add(Sf);
            BufferedWritter(Sf); 
        }
    }
    public void BufferedWritter(Staff Sf) throws IOException {
        String path = "C:\\Users\\Admin\\Documents\\GitHub\\Final-Project\\FinalProject\\Staff.txt";
        File file = new File("path");
        FileWriter fw = new FileWriter(path, true);
        String line = Sf.getID() + "," + Sf.getName() + "," + Sf.getAge() + "," + Sf.getGender() + "," + Sf.getDuty()+ "," + Sf.getWorkload()+ "," + Sf.getDept_ID();
        fw.write("\n"+line);
        fw.flush();
        fw.close();
    }   
    public static void OverWriteFile(String fileName) throws IOException{
        java.io.BufferedWriter writer = new java.io.BufferedWriter(new FileWriter(fileName));
    }
    public static void AppendToFile(String data, String fileName) throws IOException{
        java.io.BufferedWriter writer = new java.io.BufferedWriter(new FileWriter(fileName, true));
        writer.append("\n");
        writer.append(data);
        writer.close();
    }
        
    public void saveStaff() throws IOException{
        getStaffList();
        getStaff(StaffL);
    }
        
    public static void BufferedReaderFile(FileReader fileReader) throws IOException{
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
                newStaff.setDept_ID(Integer.parseInt(Mydata[6]));
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
    
            public void ChangeDept(){
        Staff Sf = new Staff(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
        tf_Duty.getText(),Integer.parseInt(tf_Workload.getText()),Integer.parseInt(tf_Dept_ID.getText()));
        for(int i = 0; i < StaffL.size(); i++){
            if(StaffL.get(i).getID()== Integer.parseInt(tf_ID.getText())){
                StaffL.set(i, Sf);        
     
            }
        }
    }
        public void search(){
        Staff newStaff = new Staff();
        Staff currentObj = new Staff();
        Iterator<Staff> iterator = StaffL.iterator();
        while(iterator.hasNext()){
            currentObj = iterator.next();
            if(currentObj.getID() == Integer.parseInt(tf_ID.getText())){
                //id,name,age,gender,duty,workload,department_idw
                newStaff.setID(currentObj.getID());
                newStaff.setName(currentObj.getName());
                newStaff.setAge(currentObj.getAge());
                newStaff.setGender(currentObj.getGender());
                newStaff.setDuty(currentObj.getDuty());
                newStaff.setWorkload(currentObj.getWorkload());
                newStaff.setDept_ID(currentObj.getDept_ID());
            }
        }
        if(newStaff.getID() != 0){
            tf_ID.setText(Integer.toString(newStaff.getID()));
            tf_Name.setText(newStaff.getName());
            tf_Age.setText(Integer.toString(newStaff.getAge()));
            tf_Gender.setText(newStaff.getGender());
            tf_Duty.setText(newStaff.getDuty());
            tf_Workload.setText(Integer.toString(newStaff.getWorkload()));
            tf_Dept_ID.setText(Integer.toString(newStaff.getDept_ID()));
        }else{
            System.out.println("Staff not found!");
        }
    }
        //The compute payroll for staff
        public void StaffPay() {
            double sal = 0;
            int workload;
            workload = Integer.parseInt(tf_Workload.getText());
            //checking if workload is over 36h
            if(workload<36){
                //equation
                sal = (workload * 32 * 2) * 0.85;
                tf_Compute_Payroll.setText(String.valueOf(sal));
            }else{
                //if workload does not make sense
                System.out.println("Working hours cannot be more than 36 hours");
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_Add.setDisable(true);
        btn_Assign_Dept.setDisable(true);
        btn_Compute_Payroll.setDisable(true);
        btn_Search.setDisable(true);
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
            btn_Load.setDisable(true);
            btn_Search.setDisable(false);
            btn_Search.setDisable(false);
            btn_Add.setDisable(false);
        }
        if(event.getSource() == btn_Add){
            saveStaff();
        }
        if(event.getSource() == btn_Assign_Dept){
            ChangeDept();
        }
        if(event.getSource() == btn_Search){
            search();
            btn_Assign_Dept.setDisable(false);
            btn_Compute_Payroll.setDisable(false);
        }
        if(event.getSource() == btn_Compute_Payroll){
            StaffPay();
            btn_Compute_Payroll.setDisable(true);
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
    cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("Dept_ID"));
    tbl_Staff.setItems(arr);
    }
}
