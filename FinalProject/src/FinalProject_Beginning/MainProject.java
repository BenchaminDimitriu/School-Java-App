package FinalProject_Beginning;
import java.util.Scanner;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import java.util.ArrayList;

public class MainProject {
    //Method to add department
    public static void addDepartment(Scanner sc, ArrayList<Department> departments){
        //Asking for input
        System.out.println("Please enter Id:");
        int id = sc.nextInt();
        System.out.println("Please enter description:");
        String desc = sc.next();
        //Making object department
        Department NewDepartment = new Department(id, desc);
        //Adding to array list
        departments.add(NewDepartment);
    }

    //Method to add Teacher
    public static void addTeacher(Scanner sc, ArrayList<Teacher> TeacherList, ArrayList<Department> departments){
        //Checking if there's department
        if(departments.size() > 0){
            //Asking for input
            System.out.println("Please enter Id:");
            int id = sc.nextInt();
            System.out.println("Please enter name:");
            String name = sc.next();
            System.out.println("Please enter age:");
            int age = sc.nextInt();
            System.out.println("Please enter gender:");
            String gender = sc.next();
            System.out.println("Please enter salary:");
            double salary = sc.nextDouble();
            System.out.println("Please enter degree:");
            String degree = sc.next();
           //Making NewTeacher object
            Teacher NewTeacher = new Teacher(id, name, age, gender, salary, degree);
            //Adding to array list
            TeacherList.add(NewTeacher);
        }
    }
    //Method to add Student
    public static void addStudent(Scanner sc, ArrayList<Student> StudentList, ArrayList<Department> departments){
        //Checking if there's department
        if(departments.size() > 0){
            //Asking for input
            System.out.println("Please enter Id:");
            int id = sc.nextInt();
            System.out.println("Please enter name:");
            String name = sc.next();
            System.out.println("Please enter age:");
            int age = sc.nextInt();
            System.out.println("Please enter gender:");
            String gender = sc.next();
            System.out.println("Please enter course:");
            String course  = sc.next();
            System.out.println("Please enter semester:");
            int semester = sc.nextInt();
            System.out.println();
            //Making NewStudent object
            Student NewStudent = new Student(id, name, age, gender, course, semester);
            //Adding to array list
            StudentList.add(NewStudent);
        }
    }
    //Method to display teachers
    public static void displayTeach(ArrayList<Teacher> TeacherList){
        for (int i = 0; i < TeacherList.size(); i++) {
            System.out.println(TeacherList.get(i));
        }
    }
    //Method to display Students
    public static void displayStu(ArrayList<Student> StudentList){
        for (int i = 0; i < StudentList.size(); i++) {
            System.out.println(StudentList.get(i));
        }
    }
    //Display departments (only departments)
    public static void displayDepts(ArrayList<Department> departments){
         for (int i = 0; i < departments.size(); i++) {
             System.out.println(departments.get(i));
            
        }
    }

    //Method to assign dean to a department
    public static void assignDean(Scanner sc, ArrayList<Teacher> TeacherList, ArrayList<Department> departments){
        //Asking for input
        displayDepts(departments);
        System.out.println("Please enter department id: ");
        int dept = sc.nextInt();
        displayTeach(TeacherList);
        System.out.println("Please enter teacher id: ");
        int deanId = sc.nextInt();
        //temp variable
        Department holdDept = null;
        //Searching for department
        for (int j = 0; j < departments.size(); j++) {
            if(departments.get(j).getId() == dept){
                holdDept = departments.get(j);
                break;
            }
        }
        //Searching for teacher to make it dean and adding to dept
        for (int i = 0; i < TeacherList.size(); i++) {
            if(TeacherList.get(i).getId() == deanId){
                holdDept.setDean(TeacherList.get(i));
                System.out.println("Succesfully added!");
                break;
            }
        }
    }
    //Method to assign teacher to department
    public static void assignTech(Scanner sc, ArrayList<Teacher> TeacherList, ArrayList<Department> departments, ArrayList<Teacher> teacherDept){
        //Asking for input
        displayDepts(departments);
        System.out.println("Please enter department id: ");
        int dept = sc.nextInt();
        displayTeach(TeacherList);
        System.out.println("Please enter teacher id: ");
        int teachID = sc.nextInt();
        //temp variable
        Department tempDept = null;
        //Searching for department
        for (int j = 0; j < departments.size(); j++) {
            if(departments.get(j).getId() == dept){
                tempDept = departments.get(j);
                break;
            }
        }
        //Searching for teacher to add to department
        for (int i = 0; i < TeacherList.size(); i++) {
            if(TeacherList.get(i).getId() == teachID){
                tempDept.addTeacherDept(TeacherList.get(i));
                System.out.println("Succesfully added!");
                break;
            }
        }
    }
    //Method to assign student to department
    public static void assignStu(Scanner sc, ArrayList<Student> StudentList, ArrayList<Department> departments, ArrayList<Student> studentDept){
        //Asking for input
        displayDepts(departments);
        System.out.println("Please enter department id: ");
        int dept = sc.nextInt();
        displayStu(StudentList);
        System.out.println("Please enter student id: ");
        int stuID = sc.nextInt();
        //temp variable
        Department tempDept = null;
        //Searching for department
        for (int j = 0; j < departments.size(); j++) {
            if(departments.get(j).getId() == dept){
                tempDept = departments.get(j);
                break;
            }
        }
        //Searching for student to add to department
        for (int i = 0; i < StudentList.size(); i++) {
            if(StudentList.get(i).getId() == stuID){
                tempDept.addStudentDept(StudentList.get(i));
                System.out.println("Succesfully added!");
                break;
            }
        }
    }
    //Method to display Dean
    public static void displayDean(ArrayList<Department> departments, Scanner sc){
        displayDepts(departments);
        //Asking for input
        System.out.println("Please enter department id: ");
        int id = sc.nextInt();
        //Searching for department
        for (int j = 0; j < departments.size(); j++) {
            if(departments.get(j).getId() == id){
                //Searching for dean
                System.out.println("Dean: " + departments.get(j).getDean());
            break;
            }
        }
    }
    //Method to display Departments
    public static void displayDeptInfo(ArrayList<Department> departments, Scanner sc){
        //Asking for input
        displayDepts(departments);
        System.out.println("Please enter department id: ");
        int dept = sc.nextInt();
        //Temp variable
        int temp = 0;
        //Searching for department
        for (int j = 0; j < departments.size(); j++) {
            if(departments.get(j).getId() == dept){
                temp = j;
                break;
            }
        }
        System.out.println("Id: " + departments.get(temp).getId() + "\nDespription: " + departments.get(temp).getDescription());
        System.out.println("Dean: " + departments.get(temp).getDean() + "\nTeachers: " + departments.get(temp).getTeacherDept());
        System.out.println("Students: "+ departments.get(temp).getStudentDept());    
    }
    

    public static void main(String[] args) {
        //ArrayLists for Teachers and Students
        ArrayList<Teacher> TeacherList = new ArrayList<Teacher>();
        ArrayList<Student> StudentList = new ArrayList<Student>();
        ArrayList<Department> departments = new ArrayList<Department>();
       
        Scanner sc = new Scanner(System.in);
        int choices = 1;
        do{
            //Menu options
            System.out.println(" 1. Add Department(please do first) \n 2. Add Teacher \n 3. Add Student \n 4. Assign Dean to Department \n 5. Assign Teacher to Department "
                    + "\n 6. Assign Student to Department \n 7. Display Departments \n 8. Display Teachers \n 9. Display Students \n 10. Display Dean \n 11. Display Department info \n 12. Quit");
            choices =sc.nextInt();
            //Menu
            System.out.println("-------------------------------------------------");
            switch (choices){
                case 1:
                    //Add Department
                    addDepartment(sc, departments);
                    //Printing out new department
                    System.out.println(departments.get(departments.size()-1));
                    break;
                case 2:
                    //Add Teacher
                    addTeacher(sc, TeacherList, departments);
                    //Printing added teacher
                    System.out.println(TeacherList.get(TeacherList.size()-1));
                    break;
                case 3:
                    //Add Student
                    addStudent(sc, StudentList, departments);
                    //Printing added Student
                    System.out.println(StudentList.get(StudentList.size()-1));
                    break;
                case 4:
                    //Assigning dean
                    assignDean(sc, TeacherList, departments);
                    break;
                case 5:
                    //Assigning teacher
                    assignTech(sc, TeacherList, departments, Department.teacherDept);
                    break;
                case 6:
                    //Assigning student
                    assignStu(sc, StudentList, departments, Department.studentDept);
                    break;
                case 7:
                    //Display departments
                    displayDepts(departments);
                    break;
                case 8:
                    //Display Teachers
                    displayTeach(TeacherList);
                    break;
                case 9:
                    //Display Students
                    displayStu(StudentList);
                    break;
                case 10:
                    //Display deans
                    displayDean(departments, sc);
                    break;
                case 11:
                    //Display department info
                    displayDeptInfo(departments,sc);
                    break;
            }
            System.out.println("-------------------------------------------------");
        }while(choices < 12);
    } 
    
}