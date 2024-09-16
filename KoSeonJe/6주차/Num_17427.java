import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Num_17427 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int result = allSum(n);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }
  //  1~n까지 약수의 합 n/i * i
  // 1~n까지 약수 각 자리수 개수 n/i
  private static int allSum(int n) {
    int sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += (n / i) * i;
    }
    return sum;
  }
}
