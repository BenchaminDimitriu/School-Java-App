/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author Admin
 */
public class TeacherMenuController implements Initializable {

    @FXML
    private VBox Teach_VBOX;
    @FXML
    private TextField tf_ID;
    @FXML
    private TextField tf_Name;
    @FXML
    private TextField tf_Age;
    @FXML
    private TextField tf_Gender;
    @FXML
    private TextField tf_Speciality;
    @FXML
    private TextField tf_Degree;
    @FXML
    private TextField tf_Dept_ID;
    @FXML
    private Button btn_Add;
    @FXML
    private Button btn_Load;
    @FXML
    private Button btn_Assign_Dept;
    @FXML
    private Button btn_Search;
    @FXML
    private Button btn_Assign_Dean;
    @FXML
    private TableView<Teacher> tbl_Teach;
    @FXML
    private TableColumn<Teacher, Integer> cln_ID;
    @FXML
    private TableColumn<Teacher, String> cln_Name;
    @FXML
    private TableColumn<Teacher, Integer> cln_Age;
    @FXML
    private TableColumn<Teacher, String> cln_Gender;
    @FXML
    private TableColumn<Teacher, String> cln_Speciality;
    @FXML
    private TableColumn<Teacher, String> cln_Degree;
    @FXML
    private TableColumn<Teacher, Integer> cln_Dept_ID;
    @FXML
    private Button btn_Back_To_Menu;
    
    private FileReader fileReader;
    
    public static ObservableList<Teacher> TeachL = FXCollections.observableArrayList();
    @FXML
    private Button btn_Compute_Payroll;
    @FXML
    private TextField tf_Compute_Payroll;
    
    public void getTeacher(ObservableList<Teacher> arr){
        cln_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cln_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cln_Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        cln_Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        cln_Speciality.setCellValueFactory(new PropertyValueFactory<>("Speciality"));
        cln_Degree.setCellValueFactory(new PropertyValueFactory<>("Degree"));
        cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("dept_ID"));
        tbl_Teach.setItems(arr);
    }
    public void getTeacherList(){
        Teacher T = new Teacher(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
                tf_Speciality.getText(),tf_Degree.getText(),Integer.parseInt(tf_Dept_ID.getText()));
        TeachL.add(T);
    }
    public void SaveTeacher(){
        getTeacherList();
        getTeacher(TeachL);
    }
    public void BufferedReaderFile(FileReader fileReader) throws IOException{
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\Dinal\\Documents\\GitHub\\Final-Project\\FinalProject\\Teacher.txt"));
            //id,name,age,gender,speciality,degree,department_id
            String line = reader.readLine();
             while(line!=null){
                System.out.println(line);
                Teacher newTeach = new Teacher();
                String Mydata[]  = line.split(",");
                newTeach.setID(Integer.parseInt(Mydata[0]));
                newTeach.setName(Mydata[1]);
                newTeach.setAge(Integer.parseInt(Mydata[2]));
                newTeach.setGender(Mydata[3]);
                newTeach.setSpeciality(Mydata[4]);
                newTeach.setDegree(Mydata[5]);
                //Teacher newTeach = new Teacher(Integer.parseInt(Mydata[0]), Mydata[1], Integer.parseInt(Mydata[2]), Mydata[3], Mydata[4], Mydata[5]);
                 for(String input: Mydata){
                    System.out.println( "Input: " + input);
                }
                line = reader.readLine();
                TeachL.add(newTeach);
             }
        }catch(FileNotFoundException lostfile){
            System.out.println(lostfile.getMessage());
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
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
            //BufferedReaderFile(fileReader);
            initiliazeTeach(TeachL);
        }
        if(event.getSource() == btn_Add){
            SaveTeacher();
        }
    }
     public void initiliazeTeach(ObservableList<Teacher> arr) throws IOException{
//                 BufferedReader reader;
//        try{
//            reader = new BufferedReader(new FileReader("C:\\Users\\Dinal\\Documents\\GitHub\\Final-Project\\FinalProject\\Teacher.txt"));
//            //id,name,age,gender,speciality,degree,department_id
//            String line = reader.readLine();
//             while(line!=null){
//                 System.out.println(line);
//                String Mydata[]  = line.split(",");
//                 Teacher newTeach = new Teacher(Integer.parseInt(Mydata[0]), Mydata[1], Integer.parseInt(Mydata[2]), Mydata[3], Mydata[4], Mydata[5], Integer.parseInt(Mydata[6]));
//                 for(String input: Mydata){
//                    System.out.println( "Input: " + input);
//                }
//                line = reader.readLine();
//                TeachL.add(newTeach);
//             }
//        }catch(FileNotFoundException lostfile){
//            System.out.println(lostfile.getMessage());
//        }
         BufferedReaderFile(fileReader);
         cln_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
         cln_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
         cln_Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
         cln_Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
         cln_Speciality.setCellValueFactory(new PropertyValueFactory<>("Speciality"));
         cln_Degree.setCellValueFactory(new PropertyValueFactory<>("Degree"));
         cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("Dept_ID"));
         tbl_Teach.setItems(arr);
     }
}