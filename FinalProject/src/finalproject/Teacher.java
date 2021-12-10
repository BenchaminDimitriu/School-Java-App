
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

    //Implementing Payroll
    @Override
    public double ComputePayRoll() {
        //salaries depending on degree
        int PhdSal = 112;
        int MasterSal = 82;
        int BachelorSal = 42;
        //switch case to calculate different salaries
        if (null != degree)
            switch (degree) {
            case "Phd":
                saldegree = (36 * PhdSal * 2);
                break;
            case "Master":
                saldegree = (36 * MasterSal * 2);
                break;
            case "Bachelor":
                saldegree = (36 * BachelorSal * 2);
                break;
            default:
                break;
        }
        return saldegree;
    }
}