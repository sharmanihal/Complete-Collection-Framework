package Collection.Map.WeakHashMap;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    //WeakHashMap is a class that implements the Map interface and is a part of java.util package.
    public static void main(String[] args) {

        //Example : we are editing a video and using an image multiple times in the video
        //We can store that image in the cache so that we don't have to load it from the disk everytime we need it
        //and when we are done and need other images we can remove the image from the cache and load the new image

        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        imageCache.put("image1",new Image("image1"));
        imageCache.put("image2",new Image("image2"));
        System.out.println(imageCache);
        simulateMethodRunning();
        //These keys will be treated as weak references and JVM will remove based on when the garbage collector runs
        //One problem here is that we are using string literals as keys and they are stored in the string pool
        //so they have a strong reference and will not be removed by the garbage collector

        //to make sure that the keys are removed by the garbage collector we can use new String("image1") instead of "image1"
        System.out.println("Cache after running (some entries may be cleared): "+imageCache);
    }

    private static void simulateMethodRunning() {
        try {
            System.out.println("Doing some work");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Image{
    private String name;
    public Image(String name ){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}