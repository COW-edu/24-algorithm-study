import java.util.*;
import java.io.*;

public class Main {
	private static final int[] count = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

	private static String solution(int[] nameSizes, String[] names) {
		int[] arr = new int[nameSizes[0] + nameSizes[1]];
		int minLength = Math.min(nameSizes[0], nameSizes[1]);

		// 두 이름을 번갈아 가며 합치는 과정
		for (int i = 0; i < minLength; i++) {
			arr[2 * i] = count[names[0].charAt(i) - 'A'];
			arr[2 * i + 1] = count[names[1].charAt(i) - 'A'];
		}

		// 더 긴 이름의 나머지 부분 추가
		if (nameSizes[0] > nameSizes[1]) {
			for (int i = minLength; i < nameSizes[0]; i++) {
				arr[minLength * 2 + (i - minLength)] = count[names[0].charAt(i) - 'A'];
			}
		} else if (nameSizes[1] > nameSizes[0]) {
			for (int i = minLength; i < nameSizes[1]; i++) {
				arr[minLength * 2 + (i - minLength)] = count[names[1].charAt(i) - 'A'];
			}
		}

		// 합산 과정
		int size = arr.length;
		while (size > 2) {
			for (int i = 0; i < size - 1; i++) {
				arr[i] = (arr[i] + arr[i + 1]) % 10;
			}
			size--;
		}

		// 결과 출력
		int result = arr[0] * 10 + arr[1];
		return result + "%";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nameSizes = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		String[] names = br.readLine().split(" ");
		String result = solution(nameSizes, names);
		resolve(result);
	}

	private static void resolve(String answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}