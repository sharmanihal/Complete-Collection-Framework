package Collection.Map.EnumMap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapDemo {
    //Enum map directly implements the Map interface
    public static void main(String[] args) {
        Map<Days,String> map = new EnumMap<>(Days.class);
        //If ll the keys in the map are values of an enum, then we can use EnumMap
        //As EnumMap which has advantage of knowing all possible keys in advance, is more efficient than HashMap
        //We wouldn't have to resize the map, since we know all the keys in advance
        //We don't generate hashcode for keys, the values are mapped to the index (ordinal) of the key in enum

        System.out.println(Days.THURSDAY.ordinal());//index of the key in the enum
        //uses the index of the key in the enum to map the value
        map.put(Days.TUESDAY,"Work");
        map.put(Days.MONDAY,"Gym");
        //No collisions
        //order is maintained, as the order of the keys in the enum
        System.out.println(map);

    }

}
enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}