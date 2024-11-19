package Collection.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        //Comparable is an interface that is used to sort objects
        //What is the difference between Comparable and Comparator?
        //Comparable is used to provide a default behaviour to class to compare its objects
        //If we dont provide any custom comparator, then the objects of the class will be compared based on the compareTo method provided by the Comparable interface
        //If we want to use any custom logic other than default compareTo method, we can use the Comparator interface


        //lets say we have a student class with name and age fields
        //we want to sort the students based on their names
        //we can implement the Comparable interface in the student class
        //and provide the logic to compare the objects based on the name field
        //and then we can use the Collections.sort method to sort the objects of the student class
        Student s1 = new Student("Mike", 20);
        Student s2 = new Student("John", 22);
        Student s3 = new Student("David", 21);
        Student s4 = new Student("Adam", 21);

        List<Student> students = new ArrayList<>(List.of(s1,s2,s3,s4));
//        Collections.sort(students);
        System.out.println(students);


        //say we want to sort the students based on their age
        //we can use the Comparator interface to provide the custom logic to compare the objects based on the age field

        Comparator<Student> studentComparator = (o1, o2) -> o1.getAge() - o2.getAge();
        //students.sort(studentComparator);
        students.sort((o1,o2)->o2.getAge()-o1.getAge());
        System.out.println(students);


    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //this compareTo method is used to compare the objects of the student class
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}