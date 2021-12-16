
package finalproject;

public class Staff extends Person implements PayRoll{
    //Variables for Staff
    private String duty;
    private int workload;
    private int dept_ID;

    Staff() {

    }

    public int getDept_ID() {
        return dept_ID;
    }

    public void setDept_ID(int dept_ID) {
        this.dept_ID = dept_ID;
    }
    private double sal;
    
    //Setters and Getters
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
    
    //Staff constructor -> make object Staff
    public Staff(int ID, String name, int age, String gender,String duty, int workload,int dept_ID) {
        super(ID, name, age, gender);
        this.dept_ID = dept_ID;
        this.duty = duty;
        this.workload = workload;
    }
    //Display Staff
    @Override
    public String toString(){
        return "Id: " + this.getID() + " Name: " + this.getName() + " Age: " + this.getAge() + " Gender: " + this.getGender() + " Duty: " + duty + " Workload: " + workload;
    } 
    
    //Implementing Payroll
    @Override
    public double ComputePayRoll() {
        //checking if workload is over 36h
        if(workload<36){
            //equation
            sal = (workload * 32 * 2) * 0.85;
        }else{
            //if workload does not make sense
            System.out.println("Working hours cannot be more than 36 hours");
        }
        return sal;
    }
}