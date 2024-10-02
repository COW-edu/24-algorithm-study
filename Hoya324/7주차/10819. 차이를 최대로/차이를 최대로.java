import java.util.*;
import java.io.*;

public class Main {

	public static int size;
	public static int[] arr;
	public static int[] answer;
	public static boolean[] visited;
	public static int result;

	// 순열을 구하고 최댓값을 계산하는 DFS 함수
	public static void DFS(int count) {
		if (count == size) {
			int sum = calculateDifference(answer);
			result = Math.max(result, sum);  // 최댓값 갱신
			return;
		}
		for (int index = 0; index < size; index++) {
			if (!visited[index]) {
				answer[count] = arr[index];
				visited[index] = true;
				DFS(count + 1);
				visited[index] = false;
			}
		}
	}

	private static int calculateDifference(int[] answer) {
		int sum = 0;
		for (int index = 0; index < size - 1; index++) {
			sum += Math.abs(answer[index] - answer[index + 1]);
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		answer = new int[size];
		visited = new boolean[size];
		
		DFS(0); 

		System.out.println(result);
	}
}