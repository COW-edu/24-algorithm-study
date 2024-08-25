import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        Point[] points;


        Input(Point[] points) {
            this.points = points;
        }
    }

    static class Output {
        Point[] sortedPoint;

        Output(Point[] sortedUserInfos) {
            this.sortedPoint = sortedUserInfos;
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        public static Point parse(String line) {
            String[] split = line.split(" ");
            return new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
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
            Point[] points = new Point[size];
            for (int i = 0; i < size; i++) {
                points[i] = Point.parse(br.readLine());
            }
            input = new Input(points);
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (Point point : output.sortedPoint) {
                bw.write(point.toString() + "\n");
            }
        }
    }

    private static Output solve(Input input) {
        Point[] sortedPoints = Arrays.stream(input.points)
                .sorted((p1, p2) -> {
                    if (p1.x != p2.x) {
                        return p1.x - p2.x;
                    }
                    return p1.y - p2.y;
                })
                .toArray(Point[]::new);
        return new Output(sortedPoints);
    }

}
