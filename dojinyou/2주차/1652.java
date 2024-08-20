import java.io.*;

public class Main {

    static final char EMPTY = '.';
    public static final int MIN_PLACE_SIZE = 2;

    static class Input {
        char[][] map;


        Input(char[][] map) {
            this.map = map;
        }
    }

    static class Output {
        int horizontalPlaceCount;
        int verticalPlaceCount;

        Output(int horizontalPlaceCount, int verticalPlaceCount) {
            this.horizontalPlaceCount = horizontalPlaceCount;
            this.verticalPlaceCount = verticalPlaceCount;
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
            int size = Integer.parseInt(br.readLine());
            char[][] map = new char[size][size];
            for (int i = 0; i < size; i++) {
                char[] horizontalMap = br.readLine().toCharArray();
                map[i] = horizontalMap;
            }
            input = new Input(map);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(output.horizontalPlaceCount + " " + output.verticalPlaceCount);
        }
    }

    private static Output solve(Input input) {
        int horizontalPlaceCount = getPlaceCount(Direction.HORIZONTAL, input.map);
        int verticalPlaceCount = getPlaceCount(Direction.VERTICAL, input.map);
        return new Output(horizontalPlaceCount, verticalPlaceCount);
    }

    private static int getPlaceCount(Direction direction, char[][] map) {
        int placeCount = 0;
        for (int i = 0; i < map.length; i++) {
            int continousEmptySpace = 0;
            for (int j = 0; j < map.length; j++) {
                char mapInfo = direction == Direction.HORIZONTAL ? map[i][j] : map[j][i];
                if (mapInfo == EMPTY) {
                    continousEmptySpace++;
                    continue;
                }

                if (MIN_PLACE_SIZE <= continousEmptySpace) {
                    placeCount++;
                }
                continousEmptySpace = 0;
            }
            if (2 <= continousEmptySpace) {
                placeCount++;
            }
        }
        return placeCount;
    }

    enum Direction {
        HORIZONTAL, VERTICAL;
    }
}
