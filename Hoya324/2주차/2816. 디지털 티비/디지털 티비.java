import java.io.*;

public class Main {

	private static final String KBS1 = "KBS1";
	private static final String KBS2 = "KBS2";

	private static String solution(int N, BufferedReader br) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		int[] k = new int[2];

		for (int i=0; i<N ; i++) {
			String channel = br.readLine();
			if(channel.equals(KBS1))
				k[0] = i;
			else if(channel.equals(KBS2))
				k[1] = i;
		}

		// kbs2, kbs1 순서이면 kbs1이 올라가면서 kbs2를 아래로 한칸 내린다
		if(k[0] > k[1]) k[1]++;

		for(int i=0; i<2; i++) {
			stringBuilder.append("1".repeat(k[i]));
			if(i==1) k[1]--;
			stringBuilder.append("4".repeat(k[i]));
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		resolve(solution(N, br));
	}

	private static void resolve(String answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(answer);
		}
	}
}
