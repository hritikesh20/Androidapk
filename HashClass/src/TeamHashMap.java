import java.util.HashMap;
import java.util.Map;

public class TeamHashMap {
    public static void main(String[] args) {

        HashMap<String ,Integer> team = new HashMap<>();

        team.put("Ritik",20);
        team.put("dhoni",7);
        team.put("Virat",18);
        team.put("Sachin",10);
        team.put("Messi",10);

//        Print Only keyValues
//        for (String name : team.keySet()){
//            System.out.println(name);
//        }
        // Print Only Vales of pair
//        for (Integer num : team.values()){
//            System.out.println(num);
//        }
//        print Key values into a pair
//        team.forEach((key,value)->{
//            System.out.println(key + "->" + value);
//        });
        // print Key values into a pair USing Map>entey Mathods
//        for (Map.Entry<String, Integer> x:team.entrySet()){
//            System.out.println(x.getKey() + "->" + x.getValue());
//        }
//
//        for (Map.Entry<String, Integer> print:team.entrySet()){
//            System.out.println(print.getKey() + "->" + print.getValue());
//        }
//
    }
}
