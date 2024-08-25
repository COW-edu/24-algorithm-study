import java.io.*;
import java.util.*;

public class Main {
	private static int solution(int[] arr, int N) {
		for (int i = 0; i < N; i++) {
			arr[i] = convertEven(arr[i]);
		}
		int count = 0;
		boolean isDone = true;
		while (true) {
			for (int i = 0; i < N - 1; i++) {
				if (arr[i] != arr[i+1] || arr[0] != arr[N-1]) {
					isDone = false;
					break;
				}
				isDone = true;
			}
			if (isDone) {
				break;
			}

			int nextCandy = arr[N-1] / 2;
			for (int i = 0; i < N; i++) {
				int halfCandy = arr[i] / 2;
				arr[i] = convertEven(halfCandy + nextCandy);
				nextCandy = halfCandy;
			}
			count++;
		}
		return count;
	}

	private static int convertEven(int candyNum) {
		if (candyNum % 2 != 0) {
			return candyNum + 1;
		}
		return candyNum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N;
		int[] arr;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			if (N == 1) {
				br.readLine();
				sb.append(0).append("\n");
				continue;
			}
			String[] temp = br.readLine().split(" ");
			arr = Arrays.stream(temp).mapToInt(Integer::parseInt)
				.toArray();
			sb.append(solution(arr, N)).append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}