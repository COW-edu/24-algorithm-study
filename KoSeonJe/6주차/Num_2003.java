import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Num_2003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = inputData(N, br);
    int count = solve(arr, M);
    bw.write(String.valueOf(count));
    br.close();
    bw.close();
  }

  private static int solve(int[] arr, int M) {
    int count = 0;
    int start = 0;
    int end = 0;
    int sum = 0;
    while (start < arr.length) {
      if (sum > M || end == arr.length) {
        sum -= arr[start++];
      } else {
        sum += arr[end++];
      }

      if (sum == M) {
        count ++;
      }
    }

    return count;
  }

  private static int plusArr(int[] arr, int startPoint, int endPoint) {
    int sum = 0;
    for (int i = startPoint; i <= endPoint; i++) {
      sum += arr[i];
    }
    return sum;
  }

  private static int[] inputData(int n, BufferedReader br) throws IOException {
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    return arr;
  }
}
