import java.util.*;
import java.io.*;

public class Main {

	private static int solution(int number) {
        int[] fiboArray = new int[number + 1];
        if (number == 1) {
            return 1;
        }
        if (number == 2) {
            return 1;
        }
        fiboArray[0] = 0;
        fiboArray[1] = 1;
        fiboArray[2] = 1;
        
        for (int i = 3; i <= number; i++) {
            fiboArray[i] = fiboArray[i-1] + fiboArray[i-2];
        }
		int answer = fiboArray[number];
		return answer;
	}

	public static void main(String[] args) throws IOException {
		int input = getInput();
		resolve(solution(input));
	}

	private static int getInput() throws IOException {
		int input;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			input = Integer.parseInt(br.readLine());
		}
		return input;
	}

	private static void resolve(int answer) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write(String.valueOf(answer));
		}
	}
}
