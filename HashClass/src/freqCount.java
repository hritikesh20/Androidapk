import java.util.HashMap;

public class freqCount {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3,2};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i])) {
                int prevCount = map.get(arr[i]);
                map.put(arr[i], prevCount + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }

        // Sum uniqe elements in arrays
        int add = 0;
        for (Integer sum : map.keySet()){
            if(map.get(sum) == 1){
                add += sum;
            }
        }
        System.out.println(add);
        System.out.println(map);
    }
}
