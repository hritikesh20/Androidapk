import java.util.ArrayList;

public class Sum {
    public static void main(String[] args) {

        ArrayList<Integer> no = new ArrayList<>();

        int n = 10;

        for (int i = 1; i<=n; i++){
            no.add(i);
        }
        int sum = 0;

        for (int i = 0; i<no.size(); i++){
            sum = sum + no.get(i);
        }

        System.out.println(sum);
        System.out.println(no);
    }
}
