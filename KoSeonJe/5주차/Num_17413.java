import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Num_17413 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String words = br.readLine();
    String reverseWords = reverse(words);
    bw.write(reverseWords);
    br.close();
    bw.close();
  }

  private static String reverse(String words) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    boolean flag = false;
    for (int i = 0; i < words.length(); i++) {
      if (words.charAt(i) == '<') {
        flag = true;
        while (!stack.isEmpty()) {
          sb.append(stack.pop());
        }
        sb.append(words.charAt(i));
        continue;
      }
      if (words.charAt(i) == '>') {
        flag = false;
        sb.append(words.charAt(i));
        continue;
      }
      if (flag) {
        sb.append(words.charAt(i));
        continue;
      }
      if (!flag) {
        if (words.charAt(i) == ' ') {
          while(!stack.isEmpty() ) {
            sb.append(stack.pop());
          }
          sb.append(words.charAt(i));
        }
        else {
          stack.push(words.charAt(i));
        }
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }

}
