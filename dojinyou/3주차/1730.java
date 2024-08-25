import java.io.*;

public class Main {

    static class Input {
        int[][] board;
        char[] commands;

        Input(int[][] board, char[] commands) {
            this.board = board;
            this.commands = commands;
        }
    }

    static class Output {
        char[][] resultBoard;

        Output(int[][] board) {
            this.resultBoard = new char[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    resultBoard[i][j] = getResultFromInt(board[i][j]);
                }
            }
        }

        private char getResultFromInt(int i) {
            switch (i) {
                case 0:
                    return '.';
                case 1:
                    return '-';
                case 2:
                    return '|';
                case 3:
                    return '+';
            }

            return ' ';
        }
    }

    public static void main(String[] args) throws IOException {
        Input input = getInput();
        Output output = solve(input);
        resolve(output);
    }

    private static Input getInput() throws IOException {
        Input input;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int boardSize = Integer.parseInt(br.readLine());
            int[][] board = new int[boardSize][boardSize];
            char[] commands = br.readLine().toCharArray();
            input = new Input(board, commands);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (char[] result : output.resultBoard) {
                bw.write(String.valueOf(result) + "\n");
            }
        }
    }

    private static final int MAX_SCORE = 3;

    private static Output solve(Input input) {
        final int MAX_LENGTH = input.board.length - 1;
        int x = 0;
        int y = 0;
        for (char commandChar : input.commands) {
            Command command = Command.from(commandChar);
            int nextX = x + command.dx;
            int nextY = y + command.dy;
            if (nextX < 0 || MAX_LENGTH < nextX || nextY < 0 || MAX_LENGTH < nextY) {
                continue;
            }
            updateScore(input.board, x, y, command);
            updateScore(input.board, nextX, nextY, command);
            x = nextX;
            y = nextY;
        }


        return new Output(input.board);
    }


    private static void updateScore(int[][] board, int x, int y, Command command) {
        if (board[x][y] != command.score && board[x][y] != MAX_SCORE) {
            board[x][y] += command.score;
        }
    }

    private static int coordinatePoint(int point, int MAX_LENGTH) {
        if (point < 0) {
            point = 0;
        }
        if (point > MAX_LENGTH) {
            point = MAX_LENGTH;
        }
        return point;
    }

    enum Command {
        RIGHT(1, 0, 1),
        LEFT(1, 0, -1),
        UP(2, -1, 0),
        DOWN(2, 1, 0),
        ;

        final int score;
        final int dx;
        final int dy;

        Command(int score, int dx, int dy) {
            this.score = score;
            this.dx = dx;
            this.dy = dy;
        }

        static Command from(char command) {
            switch (command) {
                case 'R':
                    return RIGHT;
                case 'L':
                    return LEFT;
                case 'U':
                    return UP;
                case 'D':
                    return DOWN;
            }

            throw new IllegalArgumentException();
        }
    }

}
