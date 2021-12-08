
package finalproject;

public class Staff extends Person implements PayRoll{
    //Variables for Staff
    private String duty;
    private int workload;
    
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

    /*@Override
    public double ComputePayRoll() {
        
    }
*/
}
