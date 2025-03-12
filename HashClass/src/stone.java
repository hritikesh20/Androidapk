import java.util.HashSet;

public class stone {
    public static void main(String[] args) {

        HashSet<Character> stone = new HashSet<>();

        String name = "qwertyuioasdfghjklzxcvbnmee";

        for (int i = 0; i<name.length(); i++){
            char ch = name.charAt(i);
            stone.add(ch);
        }
        System.out.println(stone);
    }
}
