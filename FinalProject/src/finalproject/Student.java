
package finalproject;

public class Student extends Person{
    //Variable for Student
    private String course;
    private int semester;
     
    //Setters & Getters
     public String getCourse() {
        return course;
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
    public Student(int id, String name, int age, String gender, String course, int semester){
        //super to call constructor from Person class
        super(id, name, age, gender);
        this.course = course;
        this.semester = semester;
    }
    //Display student info
    @Override
    public String toString(){
        return "Id: " + id + " Name: " + name + " Age: " + age + " Gender: " + gender + " Course: " + course + " Semester: " + semester;
        
    }
}