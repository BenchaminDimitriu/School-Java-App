package FinalProject_Beginning;

public class Teacher extends Person{
    //Variables for Teacher
    private double salary;
    private String degree;

    //Setters & Getters
    public void setSalary(double nsalary) {
        this.salary = nsalary;
    } 
    
    public double getSalary() {
        return this.salary;
    }
    
    public void setDegree(String ndegree) {
        this.degree = ndegree;
    }
    
    public String getDegree() {
        return this.degree;
    }
    
    //Teacher constructor -> make object Teacher
    public Teacher(int id, String name, int age, String gender, double salary, String degree){
        super(id, name, age, gender);
        this.salary = salary;
        this.degree = degree;
    }
    //Empty constructor for dean
    public Teacher(){
        
    }
    //Display teacher info
    @Override
    public String toString(){
        return "Id: " + id + " Name: " + name + " Age: " + age + " Gender: " + gender + " Salary: " + salary + " Degree: " + degree;
    }
    
}