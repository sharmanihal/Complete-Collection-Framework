package Collection.Map.HashMap;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeDemo2 {
    public static void main(String[] args) {
        //So when we create a custom class how is hashcode and equals method implemented?

        //Since every class in Java is a subclass of Object class, we can override the equals() and hashCode() methods in our custom class.
        //or we can use the default implementation provided by the Object class.
        //The default implementation of the equals() method in the Object class compares the memory addresses of the two objects.
        //The default implementation of the hashCode() method in the Object class returns the memory address of the object in integer form.

        //What is the problem with the default implementation of the equals() and hashCode() methods?
        //The default implementation of the equals() method compares the memory addresses of the two objects, which may not be what we want.
        //We may want to compare the values of the objects instead of the memory addresses.

        //Say we have a Person class with two fields name and id. We want to compare two Person objects based on their id.

        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Mike", 1);
        Person p2 = new Person("John", 2);
        Person p3 = new Person("David", 3);
        Person p4 = new Person("David", 3); //same as p3

        map.put(p1, "Engineer"); //hashcode -> some unique number
        map.put(p2, "Doctor"); //hashcode -> some unique number
        map.put(p3, "Teacher");//hashcode -> some unique number
        map.put(p4, "Manager");//hashcode -> some unique number
        //p3 and p4 hashcode will be different because we have not overridden the hashcode method in Person class
        // since p3 and p4 are same, we want to replace the designation of p3 with Manager


        //But now we have given our own implementation of the hashcode method in the Person class

        System.out.println(map.get(p3));//Teacher will now be replaced by Manager
        System.out.println(map.size());//3, since p3 and p4 are same, only one entry will be there in the map
    }
}


class Person{
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        //Using the name and id fields to generate the hashcode
        //this will make sure if two objects have same name and id, they will have same hashcode
        return Objects.hash(this.name,this.id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        //if both the object references are referring to the same object
        if (this == obj){
            return true;
        }
        //check if the object is an instance of Person class
        if(this.getClass() != obj.getClass()){
            return false;
        }

        Person p = (Person) obj;
        return this.id == p.id && this.name.equals(p.name);
    }
}