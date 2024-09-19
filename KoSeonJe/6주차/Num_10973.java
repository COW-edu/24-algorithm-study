import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Num_10973 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = inputData(n, br);
    int[] prev = calculatePrev(arr);
    if (prev == null) {
      bw.write("-1");
    } else {
      StringBuilder sb = new StringBuilder();
      for (int parm : prev) {
        if (parm == 0) {
          continue;
        }
        sb.append(parm).append(" ");
      }
      bw.write(sb.toString());
    }
    br.close();
    bw.close();
  }

  private static int[] calculatePrev(int[] arr) {
    int lastIndex = arr.length - 1;
    int startIndex = arr.length - 1;
    int standardIndex = 0;

    for (int i = lastIndex; i > 1; i--) {
      if (arr[i] >= arr[i - 1]) {
        startIndex--;
      } else {
        break;
      }
    }

    if (startIndex == 1) {
      return null;
    }

    standardIndex = startIndex - 1;

    for (int i = lastIndex; i >= startIndex; i--) {
      if (arr[standardIndex] >= arr[i]) {
        swap(standardIndex, i, arr);
        break;
      }
    }
    int count = 0;
    for (int i = 0; i <= (lastIndex - startIndex) / 2; i++) {
      swap(startIndex + count, lastIndex - count, arr);
    }
    return arr;
  }

  private static void swap(int standardIndex, int startIndex, int[] arr) {
    int temp = arr[standardIndex];
    arr[standardIndex] = arr[startIndex];
    arr[startIndex] = temp;
  }

  private static int[] inputData(int n, BufferedReader br) throws IOException {
    int[] arr = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    return arr;
  }
}
