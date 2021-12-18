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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
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
        //setting values in collumns
        cln_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cln_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cln_Age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        cln_Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        cln_Speciality.setCellValueFactory(new PropertyValueFactory<>("Speciality"));
        cln_Degree.setCellValueFactory(new PropertyValueFactory<>("Degree"));
        cln_Dept_ID.setCellValueFactory(new PropertyValueFactory<>("dept_ID"));
        tbl_Teach.setItems(arr);
    }
    public void getTeacherList() throws IOException{
        Teacher T = new Teacher(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
                tf_Speciality.getText(),tf_Degree.getText(),Integer.parseInt(tf_Dept_ID.getText()));
        boolean found = false;
        for (int i = 0; i < TeachL.size(); i++) {
            if(T.getID() == TeachL.get(i).getID()){
                found = true;
                System.out.println("Index already exists!");
                break;
            }
        }
        if (found == false){
            TeachL.add(T);
            BufferedWritter(T); 
        }
    }
    public void BufferedWritter(Teacher T) throws IOException{
        String path = "C:\\Users\\Dinal\\Documents\\GitHub\\Final-Project\\FinalProject\\Teacher.txt";
        File file = new File("path");
        FileWriter fw = new FileWriter(path, true);
        String line = T.getID() + "," + T.getName() + "," + T.getAge() + "," + T.getGender() + "," + T.getSpeciality() + "," + T.getDegree() + "," + T.getDept_ID();
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
    public void SaveTeacher() throws IOException{
        getTeacherList();
        getTeacher(TeachL);
    }
    public static void BufferedReaderFile(FileReader fileReader) throws IOException{
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
                newTeach.setDept_ID(Integer.parseInt(Mydata[6]));
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
    public void initiliazeTeach(ObservableList<Teacher> arr) throws IOException{
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
    
    public void DegreePayment(){
        int PhdSal = 112;
        int MasterSal = 82;
        int BachelorSal = 42;
        double saldegree = 0;
        String Deg;

        Deg = tf_Degree.getText();
        if("phd".equals(Deg)){
            //double saldegree;
            saldegree = (36 * PhdSal * 2);
            System.out.println(saldegree);
            //Deg = Double.toString(saldegree);        
            tf_Compute_Payroll.setText(String.valueOf(saldegree));
        }
        if("master".equals(Deg)){
            //double saldegree;
            saldegree = (36 * MasterSal * 2);
            System.out.println(saldegree);
            tf_Compute_Payroll.setText(String.valueOf(saldegree));
        }
        if("bachelor".equals(Deg)){
            //double saldegree;
            saldegree = (36 * BachelorSal * 2);
            System.out.println(saldegree);
            tf_Compute_Payroll.setText(String.valueOf(saldegree));   
        }
        tf_Compute_Payroll.setText(Double.toString(saldegree));
    }
    
    public void ChangeDept(){
        Teacher T = new Teacher(Integer.parseInt(tf_ID.getText()),tf_Name.getText(),Integer.parseInt(tf_Age.getText()),tf_Gender.getText(),
        tf_Speciality.getText(),tf_Degree.getText(),Integer.parseInt(tf_Dept_ID.getText()));
        for(int i = 0; i < TeachL.size(); i++){
            if(TeachL.get(i).getID()== Integer.parseInt(tf_ID.getText())){
                TeachL.set(i, T);        
     
            }
        }
    }
    public void search(){
        Teacher newTeach = new Teacher();
        Teacher currentObj = new Teacher();
        Iterator<Teacher> iterator = TeachL.iterator();
        while(iterator.hasNext()){
            currentObj = iterator.next();
            if(currentObj.getID() == Integer.parseInt(tf_ID.getText())){
                //id,name,age,gender,speciality,degree,department_id
                newTeach.setID(currentObj.getID());
                newTeach.setName(currentObj.getName());
                newTeach.setAge(currentObj.getAge());
                newTeach.setGender(currentObj.getGender());
                newTeach.setSpeciality(currentObj.getSpeciality());
                newTeach.setDegree(currentObj.getDegree());
                newTeach.setDept_ID(currentObj.getDept_ID());
            }
        }
        if(newTeach.getID() != 0){
            tf_ID.setText(Integer.toString(newTeach.getID()));
            tf_Name.setText(newTeach.getName());
            tf_Age.setText(Integer.toString(newTeach.getAge()));
            tf_Gender.setText(newTeach.getGender());
            tf_Speciality.setText(newTeach.getSpeciality());
            tf_Degree.setText(newTeach.getDegree());
            tf_Dept_ID.setText(Integer.toString(newTeach.getDept_ID()));
        }else{
            System.out.println("Teacher not found!");
        }
    }
//    public void assignDean(){
//        Department holdDept = null;
//        Teacher newTeach = new Teacher();
//        Teacher currentObj = new Teacher();
//        Iterator<Teacher> iterator = TeachL.iterator();
//        while(iterator.hasNext()){
//            currentObj = iterator.next();
//            if(currentObj.getID() == Integer.parseInt(tf_ID.getText())){
//                //id,name,age,gender,speciality,degree,department_id
//                newTeach.setID(currentObj.getID());
//                newTeach.setName(currentObj.getName());
//                newTeach.setAge(currentObj.getAge());
//                newTeach.setGender(currentObj.getGender());
//                newTeach.setSpeciality(currentObj.getSpeciality());
//                newTeach.setDegree(currentObj.getDegree());
//                newTeach.setDept_ID(currentObj.getDept_ID());
//                holdDept.setDean(newTeach);
//            }
//        }
//        if(newTeach.getID() != 0){
//            tf_ID.setText(Integer.toString(newTeach.getID()));
//            tf_Name.setText(newTeach.getName());
//            tf_Age.setText(Integer.toString(newTeach.getAge()));
//            tf_Gender.setText(newTeach.getGender());
//            tf_Speciality.setText(newTeach.getSpeciality());
//            tf_Degree.setText(newTeach.getDegree());
//            tf_Dept_ID.setText(Integer.toString(newTeach.getDept_ID()));
//        }else{
//            System.out.println("Teacher not found!");
//        }
//    }
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
            btn_Load.setDisable(true);
        }
        if(event.getSource() == btn_Add){
            SaveTeacher();
        }
        if(event.getSource() == btn_Compute_Payroll){
            DegreePayment();        
        }
        if(event.getSource() == btn_Assign_Dept){
            ChangeDept();
        }
        if(event.getSource() == btn_Search){
            search();
        }
        
    }    
    }
     