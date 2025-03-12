import java.util.HashSet;

public class UniqeElementsList {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        int [] arr = {1,2,3,1,1,3,4,5,6};
        int [] nums = {5,7,8,1,1,3};
        for (int i = 0; i<arr.length; i++){
            set.add(arr[i]);
        }

        for (int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }

        System.out.println(set);
    }
}
