import java.io.*;
import java.util.*;

public class Main {
	private static int solution(int J, int M, BufferedReader br) throws IOException {
		int answer = 0;
		int start = 1;
		int end = M;
		for (int i = 0; i < J; i++) {
			int apple = Integer.parseInt(br.readLine());
			if (end < apple) {
				answer += apple - end;
				start += apple - end;
				end = apple;
			} else if (start > apple) {
				answer += start - apple;
				end -= start - apple;
				start = apple;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(solution(J, M, br)));
		bw.flush();
		bw.close();
	}
}