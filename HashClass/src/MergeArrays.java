import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<>();
//        int m = 3;
//        int n = 3;
//        int [] nums1 = {1,2,3,0,0,0};
//        int [] nums2 = {2,5,6};
//
//        for (int i = 0; i<m; i++){
//            list.add(nums1[i]);
//        }
//        for (int i = 0; i<n; i++){
//            list.add(nums2[i]);
//        }
//
//        Collections.sort(list);
//        System.out.println(list);
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        int [] ans = new int[m+n];
        int x = 0;

        for (int i = 0; i<m;i++){
            ans[x++]= nums1[i];
        }

        for (int i = 0; i<n;i++){
            ans[x++]= nums2[i];
        }
        Arrays.sort(ans);

        System.out.println(Arrays.toString(ans));


    }
}