/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.TeacherMenuController.TeachL;
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
        cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("Dept_id"));
        tbl_Stu.setItems(arr);
    }
            public void getStudentList() throws IOException{
        Student S = new Student(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
                tf_Course.getText(),Integer.parseInt(tf_Semester.getText()),Integer.parseInt(tf_Dept_ID.getText()));
        //StList.add(S);
                boolean found = false;
        for (int i = 0; i < StList.size(); i++) {
            if(S.getID() == StList.get(i).getID()){
                found = true;
                System.out.println("Index already exists!");
                break;
            }
        }
        if (found == false){
            StList.add(S);
            BufferedWritter(S); 
        }
    }
    public void BufferedWritter(Student S) throws IOException{
        String path = "C:\\Users\\Dinal\\Documents\\GitHub\\Final-Project\\FinalProject\\Student.txt";
        File file = new File("path");
        FileWriter fw = new FileWriter(path, true);
        String line = S.getID() + "," + S.getName() + "," + S.getAge() + "," + S.getGender() + "," + S.getCourse() + "," + S.getSemester() + "," + S.getDept_id();
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
                public void SaveStudent() throws IOException{
        getStudentList();
        getStudent(StList);
    }
    public static void BufferedReaderFile(FileReader fileReader) throws IOException{
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\Dinal\\Documents\\GitHub\\Final-Project\\FinalProject\\Student.txt"));
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
                newStudent.setDept_id(Integer.parseInt(Mydata[6]));                
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
    
        public void ChangeDept(){
        Student S = new Student(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
                tf_Course.getText(),Integer.parseInt(tf_Semester.getText()),Integer.parseInt(tf_Dept_ID.getText()));
            for(int i = 0; i < StList.size(); i++){
                if(StList.get(i).getID()== Integer.parseInt(tf_ID.getText())){
                    StList.set(i, S);        

                }
            }
    }
        public void search(){
        Student newSt = new Student();
        Student currentObj = new Student();
        Iterator<Student> iterator = StList.iterator();
        while(iterator.hasNext()){
            currentObj = iterator.next();
            if(currentObj.getID() == Integer.parseInt(tf_ID.getText())){
                //id,name,age,gender,Course,Semester,department_id
                newSt.setID(currentObj.getID());
                newSt.setName(currentObj.getName());
                newSt.setAge(currentObj.getAge());
                newSt.setGender(currentObj.getGender());
                newSt.setCourse(currentObj.getCourse());
                newSt.setSemester(currentObj.getSemester());
                newSt.setDept_id(currentObj.getDept_id());
            }
        }
        if(newSt.getID() != 0){
            tf_ID.setText(Integer.toString(newSt.getID()));
            tf_Name.setText(newSt.getName());
            tf_Age.setText(Integer.toString(newSt.getAge()));
            tf_Gender.setText(newSt.getGender());
            tf_Course.setText(newSt.getCourse());
            tf_Semester.setText(Integer.toString(newSt.getSemester()));
            tf_Dept_ID.setText(Integer.toString(newSt.getDept_id()));
        }else{
            System.out.println("Student not found!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_Add.setDisable(true);
        btn_Search.setDisable(true);
        btn_Assign_Dept.setDisable(true);
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
            btn_Load.setDisable(true);
            btn_Add.setDisable(false);
            btn_Search.setDisable(false);
        }
        if(event.getSource() == btn_Add){
            SaveStudent();
        }
        if(event.getSource() == btn_Assign_Dept){
            ChangeDept();
        }
        if(event.getSource() == btn_Search){
            search();
            btn_Assign_Dept.setDisable(false);
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
         cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("Dept_id"));
         tbl_Stu.setItems(arr);
    }
}
