package Collection.Map;

import java.lang.ref.WeakReference;

public class GarbageCollectionDemo {

    public static void main(String[] args) {

        //This object is created in the heap memory and a reference is created in the stack memory
        //This phone reference is called strong reference
        Phone phone = new Phone("Samsung", "Galaxy S24 Ultra");
        System.out.println(phone);
        //The reference in the stack memory is set to null
        //The only reference to the object in the heap memory is now lost
        //JVM will look for objects that are not reachable by any references and will remove them from the memory
        phone = null;

        //There is something called weak reference
        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple", "iPhone 13 Pro"));
        System.out.println(phoneWeakReference.get());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //JVM will decide either to remove the object from the memory or not
        System.out.println(phoneWeakReference.get());
    }

}

class Phone{
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}