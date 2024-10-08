import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num_2751 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    List<Integer> datas = inputData(n, br);
    Collections.sort(datas);
    StringBuilder sb = new StringBuilder();
    for (int data : datas) {
      sb.append(data).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<Integer> inputData(int n, BufferedReader br) throws IOException {
    List<Integer> data = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      data.add(Integer.valueOf(br.readLine()));
    }
    return data;
  }
}
