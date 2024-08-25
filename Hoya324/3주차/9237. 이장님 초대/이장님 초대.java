import java.io.*;
import java.util.*;

public class Main {
	private static int solution(int[] arr, int N) {
		Arrays.sort(arr);
		int maxLeftDay = -1;
		for (int i = 0; i < N; i++) {
			arr[i] -= i;
			if (arr[i] > maxLeftDay) {
				maxLeftDay = arr[i];
			}
		}

		return maxLeftDay + N + 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(arr, N)));
		bw.flush();
		bw.close();
	}
}