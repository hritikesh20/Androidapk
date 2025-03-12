public class SortStr {
    public static void main(String[] args) {

        int no = 19;

        boolean ans = false;

        while (no >=10) {
            int sum = 0;
            int sq = 0;
            while (no > 0  ){
                int rem = no % 10;
                sq = rem * rem;
                sum = sum + sq;
                System.out.println(sum);
                no = no / 10;
            }
            if(no == 1){
                ans = true;
            }
            no = sum;
        }
        System.out.println(ans);
    }
}
