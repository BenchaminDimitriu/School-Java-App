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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
