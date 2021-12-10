
package finalproject;

import java.util.ArrayList;

public class Department {
   //Variables for  Department
    private int id;
    private String description;
    //Object Dean of type teacher
    private Teacher Dean = new Teacher();
    public static ArrayList<Teacher> teacherDept = new ArrayList<Teacher>();
    public static ArrayList<Student> studentDept = new ArrayList<Student>();

    //Setters & Getters
    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
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
         this.id = newId;
         this.description = newD;
     }
    //Constructor to make Dept with all info
     public Department(int newId, String newD, ArrayList<Teacher> teacherDept, ArrayList<Student> studentDept, Teacher dean) {
        this.id = newId;
        this.description = newD;
        this.teacherDept = teacherDept;
        this.studentDept = studentDept;
        this.Dean = dean;
    }
    //Display department 
    @Override
    public String toString(){
        return "Id: " + id + " Description: " + description;
    } 
}