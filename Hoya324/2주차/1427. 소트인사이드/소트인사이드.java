import java.io.*;
import java.util.*;

public class Main {
	private static String solution(String str) {
		StringBuilder answer = new StringBuilder();
		
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			nums.add(Character.getNumericValue(str.charAt(i)));
		}

		nums.sort(Collections.reverseOrder());
		for (int i : nums) {
			answer.append(i);
		}
		return answer.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solution(str));
		bw.flush();
		bw.close();
	}
}