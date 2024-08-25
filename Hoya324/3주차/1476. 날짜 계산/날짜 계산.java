import java.io.*;
import java.util.*;

public class Main {
	private final static int EARTH_COUNT = 15;
	private final static int SUN_COUNT = 28;
	private final static int MOON_COUNT = 19;

	private static int solution(int[] arr) {

		int E = arr[0];
		int S = arr[1];
		int M = arr[2];
		int year = 0;
		while (true) {
			year++;
			if ((year - E) % EARTH_COUNT == 0 && (year - S) % SUN_COUNT == 0 && (year - M) % MOON_COUNT == 0) {
				break;
			}
		}
		return year;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(arr)));
		bw.flush();
		bw.close();
	}
}