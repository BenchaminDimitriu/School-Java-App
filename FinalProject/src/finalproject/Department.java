
package finalproject;

import java.util.ArrayList;

public class Department {

//    static Object getScene() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
   //Variables for  Department
    private int ID;
    private String description;
    //Object Dean of type teacher
    private Teacher Dean = new Teacher();
    public static ArrayList<Teacher> teacherDept = new ArrayList<Teacher>();
    public static ArrayList<Student> studentDept = new ArrayList<Student>();
    public static ArrayList<Staff> staffDept = new ArrayList<Staff>();

    public Department() {
    
    }

    //Setters & Getters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Teacher> getTeacherDept() {
        return teacherDept;
    }

    public ArrayList<Student> getStudentDept() {
        return studentDept;
    }
    
    public ArrayList<Staff> getStaffDept(){
        return staffDept;
    }

    //Methods to add to department
    //Teacher
    public void addTeacherDept(Teacher teacher){
        teacherDept.add(teacher);
    }
    //Student
    public void addStudentDept(Student student){
        studentDept.add(student);
    }
    //Set Dean & Get Dean
    public void setDean(Teacher teach){
        this.Dean = teach;    
    }
    public Teacher getDean(){
        return this.Dean;    
    }

    //Constructor to make Dept
     public Department(int newId, String newD){
         this.ID = newId;
         this.description = newD;
     }
    //Constructor to make Dept with all info
     public Department(int newId, String newD, ArrayList<Teacher> teacherDept, ArrayList<Student> studentDept, Teacher dean) {
        this.ID = newId;
        this.description = newD;
        this.teacherDept = teacherDept;
        this.studentDept = studentDept;
        this.Dean = dean;
    }
    //Display department 
    @Override
    public String toString(){
        return "Id: " + ID + " Description: " + description;
    } 
}