import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        } 

        ArrayList<Integer> solArr = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < K; i++) {
            start += arr.get(i);
        }

        solArr.add(start);

        for (int i = 1; i < N-(K-1); i++) {
            solArr.add(solArr.get(i-1) - arr.get(i-1) + arr.get(i+K-1));
        }

        int max = Collections.max(solArr);

        System.out.println(max);
        
    }
}