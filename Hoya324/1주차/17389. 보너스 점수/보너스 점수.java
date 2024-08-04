import java.util.*;
import java.io.*;

public class Main {
    
    private static final String O = "O";
    private static final String X = "X";

	private static int solution(String[] solves, int T) {
		int score = 0;
        int bonus = 0;
        for (int i = 0; i < T; i++) {
            if (solves[i].equals(O)) {
                score += (i + 1 + bonus);
                bonus += 1;
            }
            
            if (solves[i].equals(X)) {
                bonus = 0;
            }
        }
		return score;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] input = getInput(br);
		resolve(solution(input, T));
	}

	private static String[] getInput(BufferedReader br) throws IOException {
		return br.readLine().split("");
	}

	private static void resolve(int answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}