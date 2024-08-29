import java.io.*;
import java.util.*;

public class Main {
	private static String solution(int[] comparingArray, int[] targets) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(comparingArray);
		int size = comparingArray.length;
		for (int target : targets) {
			sb.append(binarySearch(target, comparingArray, 0, size - 1)).append("\n");
		}
		return sb.toString();
	}

	private static int binarySearch(int target, int[] comparingArray, int start, int end) {
		if (start > end) {
			return 0;
		}

		int mid = (start + end) / 2;

		if (comparingArray[mid] == target) {
			return 1;
		}

		if (target < comparingArray[mid]) {
			return binarySearch(target, comparingArray, start, mid - 1);
		}
		return binarySearch(target, comparingArray, mid + 1, end);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();

		int[] comparingArray = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		br.readLine();

		int[] targets = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(comparingArray, targets)));
		bw.flush();
		bw.close();
	}
}