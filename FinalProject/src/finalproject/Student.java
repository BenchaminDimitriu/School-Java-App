
package finalproject;

public class Student extends Person{
    //Variable for Student
    private String course;
    private int semester;
    private int Dept_id; 

    Student() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Setters & Getters
     public String getCourse() {
        return course;
    }

    public int getDept_id() {
        return Dept_id;
    }

    public void setDept_id(int Dept_id) {
        this.Dept_id = Dept_id;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    //Student constructor -> make object Student
    public Student(int ID, String name, int age, String gender, String course, int semester,int Dept_id){
        //super to call constructor from Person class
        super(ID, name, age, gender);
        this.course = course;
        this.semester = semester;
        this.Dept_id = Dept_id;
    }
    //Display student info
    @Override
    public String toString(){
        return "Id: " + this.getID() + " Name: " + this.getName() + " Age: " + this.getAge() + " Gender: " + this.getGender() + " Course: " + course + " Semester: " + semester;
        
    }
}