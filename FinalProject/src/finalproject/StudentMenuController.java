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

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class StudentMenuController implements Initializable {

    @FXML
    private TextField tf_ID;
    @FXML
    private TextField tf_Name;
    @FXML
    private TextField tf_Age;
    @FXML
    private TextField tf_Gender;
    @FXML
    private Button btn_Add;
    @FXML
    private Button btn_Load;
    @FXML
    private Button btn_Assign_Dept;
    @FXML
    private Button btn_Search;
    @FXML
    private TableColumn<Student,Integer> cln_ID;
    @FXML
    private TableColumn<Student,String> cln_Name;
    @FXML
    private TableColumn<Student,Integer> cln_Age;
    @FXML
    private TableColumn<Student,String> cln_Gender;
    @FXML
    private TextField tf_Dept_ID;
    @FXML
    private TableColumn<Student,Integer> cln_Dept_ID;
    @FXML
    private Button btn_Back_To_Menu;
    @FXML
    private TextField tf_Course;
    @FXML
    private TextField tf_Semester;
    @FXML
    private TableView<Student> tbl_Stu;
    @FXML
    private TableColumn<Student, Integer> cln_Course;
    @FXML
    private TableColumn<Student, Integer> cln_Semester;
    
    private FileReader filereader;

    public static ObservableList<Student> StList = FXCollections.observableArrayList();
    
        public void getStudent(ObservableList<Student> arr){
        cln_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cln_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cln_Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        cln_Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        cln_Course.setCellValueFactory(new PropertyValueFactory<>("Course"));
        cln_Semester.setCellValueFactory(new PropertyValueFactory<>("Semester"));
        cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("dept_ID"));
        tbl_Stu.setItems(arr);
    }
            public void getStudentList(){
        Student S = new Student(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
                tf_Course.getText(),Integer.parseInt(tf_Semester.getText()),Integer.parseInt(tf_Dept_ID.getText()));
        StList.add(S);
    }
                public void SaveTeacher(){
        getStudentList();
        getStudent(StList);
    }
    public void BufferedReaderFile(FileReader fileReader) throws IOException{
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Documents\\GitHub\\Final-Project\\FinalProject\\Student.txt"));
            //id,name,age,gender,Course,Semester,department_id
            String line = reader.readLine();
             while(line!=null){
                System.out.println(line);
                Student newStudent = new Student();
                String Mydata[]  = line.split(",");
                newStudent.setID(Integer.parseInt(Mydata[0]));
                newStudent.setName(Mydata[1]);
                newStudent.setAge(Integer.parseInt(Mydata[2]));
                newStudent.setGender(Mydata[3]);
                newStudent.setCourse(Mydata[4]);
                newStudent.setSemester(Integer.parseInt(Mydata[5]));
                 for(String input: Mydata){
                    System.out.println( "Input: " + input);
                }
                line = reader.readLine();
                StList.add(newStudent);
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
    private void handleButtonAction(ActionEvent event) throws IOException{
        if(event.getSource() == btn_Load){
            InitiliazeStudent(StList);
        }
    } 
    public void InitiliazeStudent(ObservableList<Student> arr) throws IOException{
        BufferedReaderFile(filereader);
         cln_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
         cln_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
         cln_Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
         cln_Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
         cln_Course.setCellValueFactory(new PropertyValueFactory<>("Course"));
         cln_Semester.setCellValueFactory(new PropertyValueFactory<>("Semester"));
         cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("Dept_ID"));
         tbl_Stu.setItems(arr);
    }
}
