import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{


	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(scan.readLine());

        int a = 1;
        int d = 8;
        for (int i = 0; i < 8; i++) {

            int data = Integer.parseInt(st.nextToken());
            
            if (a == data) {
                a++;
            }
            else if (d == data) {
                d--;
            }
        }
        
        if (a == 9) {
            System.out.print("ascending");
        }
        else if (d == 1) {
            System.out.print("descending");
        }
        else {
            System.out.println("mixed");
        }
    
    }
}   