import java.util.Arrays;
import java.util.HashMap;

public class Tesing {
    public static void main(String[] args) {

        int n = 45;
        boolean ans = true;

        while (n>=3){
           // System.out.println("N" + n);
            if(n % 3 != 0){
                System.out.println("%"+n);
                ans = false;
            }
            n = n/3;
            System.out.println(n);
        }

        System.out.println(ans);


    }
}
