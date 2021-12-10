
package finalproject;

abstract class Person {
    //Person variables
   protected int id;
   protected String name;
   protected int age;
   protected String gender;
   
   //Setters & Getters
 public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
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
    public Person(int id, String name, int age, String gender){
       this.id = id;
       this.name = name;
       this.age = age;
       this.gender = gender;
   }
}