
package finalproject;

abstract class Person {
    //Person variables
   private int ID;
   private String name;
   private int age;
   private String gender;
   
   //Setters & Getters
 public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    
    public Person(){
        
    }
  
    //Person constructor -> make object Person
    public Person(int ID, String name, int age, String gender){
       this.ID = ID;
       this.name = name;
       this.age = age;
       this.gender = gender;
   }
}