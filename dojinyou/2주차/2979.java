import java.io.*;
import java.util.Arrays;

public class Main {

    static class Input {
        int[] parkingFeeByNumOfCars;
        int[][] carParkingTimes;

        Input(int[] parkingFeeByNumOfCars, int[][] carParkingTimes) {
            this.parkingFeeByNumOfCars = parkingFeeByNumOfCars;
            this.carParkingTimes = carParkingTimes;
        }
    }

    static class Output {
        int totalParkingFee;

        Output(int totalParkingFee) {
            this.totalParkingFee = totalParkingFee;
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
            int[] parkingFeeByNumOfCars = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] carATimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] carBTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] carCTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            input = new Input(parkingFeeByNumOfCars, new int[][]{carATimes, carBTimes, carCTimes});
        }
        return input;
    }

    private static void resolve(Output output) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(String.valueOf(output.totalParkingFee));
        }
    }

    private static Output solve(Input input) {
        int[] parkingCars = new int[101];
        for (int[] parkingTime : input.carParkingTimes) {
            for (int i = parkingTime[0]; i < parkingTime[1]; i++) {
                parkingCars[i]++;
            }
        }

        int totalParkingFee = 0;
        for (int i = 0; i < parkingCars.length; i++) {
            int numOfParkingCar = parkingCars[i];
            if (numOfParkingCar <= 0 || 3 < numOfParkingCar) {
                continue;
            }
            totalParkingFee += numOfParkingCar * input.parkingFeeByNumOfCars[numOfParkingCar - 1];
        }
        return new Output(totalParkingFee);
    }
}
