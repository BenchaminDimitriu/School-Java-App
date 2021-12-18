/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.StaffMenuController.StaffL;
import static finalproject.StudentMenuController.StList;
import static finalproject.TeacherMenuController.TeachL;
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
public class DepartmentMenuController implements Initializable {

    @FXML
    private TableView<Teacher> tbl_Teacher;
    @FXML
    private TableColumn<Teacher, Integer> cln_Teach_ID;
    @FXML
    private TableColumn<Teacher, String> cln_Teach_Name;
    @FXML
    private TableView<Student> tbl_Student;
    @FXML
    private TableColumn<Student, Integer> cln_Stu_ID;
    @FXML
    private TableColumn<Student, Integer> cln_Stu_Name;
    @FXML
    private TableView<Staff> tbl_Staff;
    @FXML
    private TableColumn<Staff, Integer> cln_Staff_ID;
    @FXML
    private TableColumn<Staff, String> cln_Staff_Name;
    @FXML
    private TextField tf_dept_ID;
    @FXML
    private Button btn_Dept_ID;
    @FXML
    private TableView<Department> tbl_Department;
    @FXML
    private TableColumn<Department,Integer> cln_Dept_ID;
    @FXML
    private TableColumn<Department, String> cln_Dept_Desc;
    @FXML
    private Button btn_Load;
    @FXML
    private Button btn_Back_To_Menu;
    
    private FileReader fileReader;
    
    public static ObservableList<Department> DeptL = FXCollections.observableArrayList();
    public static ObservableList<Teacher> Teach_ID_NameL = FXCollections.observableArrayList();
    public static ObservableList<Staff> Staff_ID_NameL = FXCollections.observableArrayList();
    public static ObservableList<Student> St_ID_NameL = FXCollections.observableArrayList();
    @FXML
    private Button btn_Clear;

    public void BufferedReaderFile(FileReader fileReader) throws IOException{
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\Dinal\\Documents\\GitHub\\Final-Project\\FinalProject\\Department.txt"));
            //id,description
            String line = reader.readLine();
            while(line!=null){
                System.out.println(line);
                Department newDept = new Department();
                String Mydata[] = line.split(",");
                newDept.setID(Integer.parseInt(Mydata[0]));
                newDept.setDescription(Mydata[1]);
                for(String input: Mydata){
                   System.out.println( "Input: " + input);
                }
                line = reader.readLine();
                DeptL.add(newDept);
             }
        }catch(FileNotFoundException lostfile){
            System.out.println(lostfile.getMessage());
        }
    }
    public void initializeDept(ObservableList<Department> arr) throws IOException{
        BufferedReaderFile(fileReader);
        cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cln_Dept_Desc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tbl_Department.setItems(arr);
    }
    public void searchTeach() throws IOException{
        TeacherMenuController.BufferedReaderFile(fileReader);
        boolean found = false;
        Department newDept = new Department();
        newDept.setID(Integer.parseInt(tf_dept_ID.getText()));
        for (int i = 0; i < TeachL.size(); i++) {
                if(TeachL.get(i).getDept_ID() == newDept.getID()){
                    found = true;
                    Teach_ID_NameL.add(TeachL.get(i));
//                    System.out.println("in loop");
                }
                else{
                    System.out.println("ID does not exsist!");
                }
        }
        if (found){
//            System.out.println("out loop");
            cln_Teach_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            cln_Teach_Name.setCellValueFactory(new PropertyValueFactory<>("Name")); 
            tbl_Teacher.setItems(Teach_ID_NameL);
        }
    }
      public void searchStaff() throws IOException{
        StaffMenuController.BufferedReaderFile(fileReader);
        boolean found = false;
        Department newDept = new Department();
        newDept.setID(Integer.parseInt(tf_dept_ID.getText()));
        for (int i = 0; i < StaffL.size(); i++) {
                if(StaffL.get(i).getDept_ID() == newDept.getID()){
                    found = true;
                    Staff_ID_NameL.add(StaffL.get(i));
//                    System.out.println("in loop");
                }
                else{
                    System.out.println("ID does not exsist!");
                }
        }
        if (found){
//            System.out.println("out loop");
            cln_Staff_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            cln_Staff_Name.setCellValueFactory(new PropertyValueFactory<>("Name")); 
            tbl_Staff.setItems(Staff_ID_NameL);
        }
    }
      public void searchStudent() throws IOException{
        StudentMenuController.BufferedReaderFile(fileReader);
        boolean found = false;
        Department newDept = new Department();
        newDept.setID(Integer.parseInt(tf_dept_ID.getText()));
        for (int i = 0; i < StList.size(); i++) {
                if(StList.get(i).getDept_id() == newDept.getID()){
                    found = true;
                    St_ID_NameL.add(StList.get(i));
//                    System.out.println("in loop");
                }
                else{
                    System.out.println("ID does not exsist!");
                }
        }
        if (found){
//            System.out.println("out loop");
            cln_Stu_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            cln_Stu_Name.setCellValueFactory(new PropertyValueFactory<>("Name")); 
            tbl_Student.setItems(St_ID_NameL);
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
            initializeDept(DeptL);
            btn_Load.setDisable(true);            
        }
        if(event.getSource() == btn_Dept_ID){
            searchTeach();
            searchStaff();
            searchStudent();
            tf_dept_ID.clear();
        }
        if(event.getSource() == btn_Clear){
            tbl_Teacher.getItems().clear();
            tbl_Student.getItems().clear();
            tbl_Staff.getItems().clear();
            TeachL.clear();
            StaffL.clear();
            StList.clear();
        }
    }
}
