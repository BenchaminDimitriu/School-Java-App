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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
