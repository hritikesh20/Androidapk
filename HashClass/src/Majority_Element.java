import java.util.HashMap;

public class Majority_Element {
    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {

                int prevCount = map.get(arr[i]);
                map.put(arr[i], prevCount + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        System.out.println(map);
        int size = arr.length / 2;

        for (int x : map.keySet()) {
            if (map.get(x) > size) {
                System.out.println(x);
            }
        }
    }
}
