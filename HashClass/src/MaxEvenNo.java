import java.util.HashMap;

public class MaxEvenNo {
    public static void main(String[] args) {

        int[] arr = {0,1,2,0,0,0,0,2,4,4,4,1,2,2};
                //{29,47,21,41,13,37,25,7};
        //{0, 1, 2, 2, 4, 4,4, 1};//{4,4,4,9,2,4,1,};
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int prevCount = map.get(arr[i]);
                map.put(arr[i],prevCount + 1);
            } else if (arr[i] % 2 == 0) {
                map.put(arr[i],1);
            }
            else{
                ans = -1;
            }
        }
        System.out.println(map);
        int max = 0;
        for (Integer x : map.keySet()){
            if(map.get(x) > max ){
                max = x;
            }
        }

        System.out.println(max);

    }
}
