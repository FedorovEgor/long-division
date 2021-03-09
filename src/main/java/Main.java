import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a dividend, it must be an integer number :");
        int dividend = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter a divisor, it must be an integer number :");
        int divisor = Integer.parseInt(bufferedReader.readLine());

        IntegerDivision division = new IntegerDivision();
        String resultOfDivision = division.getDivisionResult(dividend, divisor);
        System.out.println(resultOfDivision);
    }
}

