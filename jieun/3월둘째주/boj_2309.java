import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2309 {
    static int sum;
    static int[] arr;
    static int i,j;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        sum =0;
        for (int l = 0; l < 9; l++) {
            arr[l] = Integer.parseInt(br.readLine());
            sum += arr[l];
        }
        Arrays.sort(arr);

        remove();

        for (int k = 0; k < 9; k++) {
            if (k == i || k == j)
                continue;
            System.out.println(arr[k]);
        }

    }

    static void remove(){
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (i == j) continue;
                if (sum - arr[i] - arr[j] == 100)
                    return;
            }
        }
    }


}
