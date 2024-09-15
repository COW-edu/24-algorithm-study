import java.io.*;
import java.util.*;

public class Main {

	private static String solution(int size) {
		StringBuilder sb = new StringBuilder();
		int[] initArray = new int[size];
		for (int index = 0; index < size; index++) {
			initArray[index] = index + 1;
			sb.append(index+1).append(" ");
		}
		sb.append("\n");

		while (true){
			int target = -1;
			for (int i = size - 1; i > 0; i--) {
				if (initArray[i - 1] < initArray[i]) {
					target = i - 1;
					break;
				}
			}

			if (target == -1) {
				break;
			}

			int swapIndex = size - 1;
			for (int i = size - 1; i > target; i--) {
				if (initArray[target] < initArray[i]) {
					swapIndex = i;
					break;
				}
			}

			swap(target, swapIndex, initArray);

			Arrays.sort(initArray, target + 1, size);

			for (int num : initArray) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	private static void swap(int a, int b, int[] array) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());

		bw.write(solution(size));
		bw.flush();
		bw.close();
	}
}