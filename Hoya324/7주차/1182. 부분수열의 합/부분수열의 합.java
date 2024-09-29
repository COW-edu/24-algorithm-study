import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] numbers;
	static int count = 0;

	static void findSubsequences(int index, int currentSum) {
		if (index == N) {
			if (currentSum == S) {
				count++;
			}
			return;
		}

		findSubsequences(index + 1, currentSum + numbers[index]);
		findSubsequences(index + 1, currentSum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		findSubsequences(0, 0);

		if (S == 0) {
			count--;
		}

		System.out.println(count);
	}
}