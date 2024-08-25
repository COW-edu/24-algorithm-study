import java.io.*;

public class Main {


    static class Input {
        final int earthCount;
        final int sunCount;
        final int moonCount;

        Input(int earthCount, int sunCount, int moonCount) {
            this.earthCount = earthCount;
            this.sunCount = sunCount;
            this.moonCount = moonCount;
        }
    }

    static class Output {
        final int year;

        Output(int year) {
            this.year = year;
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
            String[] split = br.readLine().split(" ");
            input = new Input(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.year));
        }
    }

    private static final int MAX_EARTH_COUNT = 15;
    private static final int MAX_SUN_COUNT = 28;
    private static final int MAX_MOON_COUNT = 19;

    private static Output solve(Input input) {
        int year = 0;
        int sunCircle = 0;
        boolean found = false;
        while (!found) {
            year = input.sunCount + (sunCircle * MAX_SUN_COUNT);
            if (year % MAX_EARTH_COUNT == input.earthCount % MAX_EARTH_COUNT
                    && year % MAX_MOON_COUNT == input.moonCount % MAX_MOON_COUNT) {
                found = true;
            }
            sunCircle++;

        }

        return new Output(year);
    }
}
