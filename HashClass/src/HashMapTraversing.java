import java.util.HashMap;
import java.util.Map;

public class HashMapTraversing {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        map.put("Raghav", "ME");
        map.put("Lakshay", "EC");
        map.put("Rohan", "IT");
        map.put("Akash", "CSE");


        for (String a : map.keySet()) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (String a : map.values()) {
            System.out.print(a + " ");
        }
        System.out.println();
//        map.forEach((key, value) -> {
//                    System.out.println(key + "->" + value);
//                }
//        );

        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()
                    + "->" + entry.getValue());
        }


    }
}
