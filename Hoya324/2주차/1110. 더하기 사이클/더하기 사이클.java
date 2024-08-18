import java.io.*;

public class Main {
	
	private static int solution(int N) {
		int original = N;
		int count = 0;

		do {
			int firstDigit = N / 10;
			int secondDigit = N % 10;
			int sum = firstDigit + secondDigit;

			N = (secondDigit * 10) + (sum % 10); 
			count++;
		} while (N != original);

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = solution(N);
		resolve(result);
	}

	private static void resolve(int answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}