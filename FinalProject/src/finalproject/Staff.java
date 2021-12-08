
package finalproject;

public class Staff extends Person implements PayRoll{
    //Variables for Staff
    private String duty;
    private int workload;
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
    public Staff(String duty, int workload, int id, String name, int age, String gender) {
        super(id, name, age, gender);
        this.duty = duty;
        this.workload = workload;
    }
    //Display Staff
    @Override
    public String toString(){
        return "Id: " + id + " Name: " + name + " Age: " + age + " Gender: " + gender + " Duty: " + duty + " Workload: " + workload;
    } 

    @Override
    public double ComputePayRoll() {
        if(workload<36){
            sal = (workload * 32 * 2) * 0.85;
        }else{
            System.out.println("Working hours cannot be more than 36 hours");
        }
        return sal;
    }
}
