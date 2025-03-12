import java.util.HashMap;

public class CountChar {
    public static void main(String[] args) {

        String name = "helloXhello";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i<name.length(); i++){
            if(map.containsKey(name.charAt(i))){
                int prevCount = map.get(name.charAt(i));
                map.put(name.charAt(i),prevCount  + 1);
            }
            else {
                map.put(name.charAt(i),1);
            }
        }


        for (Character uniq : map.keySet()){
            if(map.get(uniq) == 1){
                System.out.println(uniq);
            }
        }
        System.out.println(map);
    }
}
