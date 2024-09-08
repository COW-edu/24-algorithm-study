import java.io.*;

public class Main {

	private static int solution(int num) {
		int two = 0, five = 0;

		for(int j = 2; j <= num; j *= 2){
			two += num / j;
		}
		for(int j = 5; j <= num; j *= 5){
			five += num / j;
		}
		return Math.min(two, five);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCase; i++) {
			sb.append(solution(Integer.parseInt(br.readLine()))).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}