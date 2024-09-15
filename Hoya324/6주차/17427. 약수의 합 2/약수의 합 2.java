import java.io.*;

public class Main {


	private static long solution(int number) {
		long result = 0;
		for (int i = 1; i <= number; i++) {
			result += (long) (i * (number / i));
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(String.valueOf(solution(Integer.parseInt(br.readLine()))));
		bw.flush();
		bw.close();
	}
}