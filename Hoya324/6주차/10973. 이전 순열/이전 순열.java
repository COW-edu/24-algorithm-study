import java.io.*;
import java.util.*;

public class Main {

	private static String solution(int size, int[] currentPermutation) {
		// 1. 뒤에서부터 탐색하여 첫 번째로 증가하는 위치(target) 찾기
		int target = -1;
		for (int i = size - 1; i > 0; i--) {
			if (currentPermutation[i - 1] > currentPermutation[i]) {
				target = i - 1;
				break;
			}
		}

		// 2. 가장 처음 순열일 경우 -1 리턴
		if (target == -1) {
			return "-1";
		}

		// 3. target 뒤에 있는 배열에서 target보다 작은 값 중 가장 큰 값을 찾기
		int swapIndex = size - 1;
		for (int i = size - 1; i > target; i--) {
			if (currentPermutation[target] > currentPermutation[i]) {
				swapIndex = i;
				break;
			}
		}

		// 4. target과 swapIndex의 값 교환
		swap(target, swapIndex, currentPermutation);

		// 5. target 이후 부분을 내림차순으로 정렬
		reverse(currentPermutation, target + 1, size - 1);

		// 6. 결과를 StringBuilder로 만들어 리턴
		StringBuilder sb = new StringBuilder();
		for (int num : currentPermutation) {
			sb.append(num).append(" ");
		}

		return sb.toString().trim();
	}

	private static void swap(int a, int b, int[] array) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	// 배열의 일부를 뒤집는 메서드
	private static void reverse(int[] array, int start, int end) {
		while (start < end) {
			swap(start, end, array);
			start++;
			end--;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력 받기
		int size = Integer.parseInt(br.readLine());
		int[] currentPermutation = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		// 결과 출력
		bw.write(solution(size, currentPermutation));
		bw.flush();
		bw.close();
	}
}