import java.util.HashSet;

public class UniqeNoSum {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        int [] arr = {1,1,1,1,1};

        for (int i = 0; i<arr.length; i++){
            if(set.contains(arr[i])){
                set.remove(arr[i]);
            }
            else {
                set.add(arr[i]);
            }
        }
        int sum = 0;

        for ( int nums : set){
            sum = sum + nums;
        }

        System.out.println(sum);
        System.out.println(set);
    }
}