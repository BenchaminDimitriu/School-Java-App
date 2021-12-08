
package finalproject;

public class Teacher extends Person implements PayRoll{
     //Variables for Teacher
    private String speciality;
    private String degree;
    private double saldegree;

    //Setters & Getters
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
    public void setDegree(String ndegree) {
        this.degree = ndegree;
    }
    
    public String getDegree() {
        return this.degree;
    }
    
    //Teacher constructor -> make object Teacher
    public Teacher(int id, String name, int age, String gender, String speciality, String degree){
        super(id, name, age, gender);
        this.speciality = speciality;
        this.degree = degree;
    }
    //Empty constructor for dean
    public Teacher(){
        
    }
    //Display teacher info
    @Override
    public String toString(){
        return "Id: " + id + " Name: " + name + " Age: " + age + " Gender: " + gender + " Speciality: " + speciality + " Degree: " + degree;
    }

    //@Override
    ///public double ComputePayRoll() {
        //String Phd;
        //if(degree == Phd){
            
        //}
        
    //}
    
}
