import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	private static String solution(String[] arr) {

		ArrayList<BigInteger> result = new ArrayList<>();

		for (String s : arr) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {

				if (Character.isDigit(s.charAt(j))) {

					sb.append(s.charAt(j));

					if (j == s.length() - 1) {
						result.add(new BigInteger(sb.toString()));
						sb.delete(0, sb.length());
					}
				} else {
					if (sb.length() != 0) {
						result.add(new BigInteger(sb.toString()));
						sb.delete(0, sb.length());
					}
				}

			}
		}

		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		return sb.toString();
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(arr)));
		bw.flush();
		bw.close();
	}
}