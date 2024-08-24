import java.io.*;
import java.util.*;


public class Main {
	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	private static final int INIT_ASCII = 46;
	private static final int VERTICAL_ASCII = 124;
	private static final int HORIZONTAL_ASCII = 45;
	private static final int CROSS_ASCII = 43;

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};

	private static int findDirectionNumber(char direction) {
		if (direction == 'U') {
			return UP;
		}
		if (direction == 'D') {
			return DOWN;
		}
		if (direction == 'L') {
			return LEFT;
		}
		if (direction == 'R') {
			return RIGHT;
		}
		return UP;
	}

	private static String solution(int N, char[] move, char[][] pan) {
		int x = 0;
		int y = 0;

		for (char currentMove : move) {
			int number = findDirectionNumber(currentMove);

			int nextX = x + dx[number];
			int nextY = y + dy[number];

			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;

			char draw = number == UP || number == DOWN ? (char)VERTICAL_ASCII : (char)HORIZONTAL_ASCII;
			pan[y][x] = pan[y][x] == INIT_ASCII || pan[y][x] == draw ? draw : (char)CROSS_ASCII;

			x = nextX;
			y = nextY;
			pan[y][x] = pan[y][x] == INIT_ASCII || pan[y][x] == draw ? draw : (char)CROSS_ASCII;
		}

		StringBuilder sb = new StringBuilder();
		for (char[] panUnit : pan) {
			for(char dot : panUnit) {
				sb.append(dot);
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] move = br.readLine().toCharArray();
		char[][] pan = new char[N][N];
		for (char[] panUnit : pan) {
			Arrays.fill(panUnit, (char) INIT_ASCII);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(solution(N, move, pan));
		bw.flush();
		bw.close();
	}
}