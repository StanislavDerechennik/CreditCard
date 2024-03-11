import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static void luhns(long number) {
        int[] digits = Long.toString(number).chars().map(c -> c-'0').toArray();
        int sum = 0;
        for (int i = digits.length - 2; i >= 0 ; i -= 2) {
            if (digits[i] == 1)
                sum += 2;
            else if (digits[i] == 2)
                sum += 4;
            else if (digits[i] == 3)
                sum += 6;
            else if (digits[i] == 4)
                sum += 8;
            else if (digits[i] == 5)
                sum += 1;
            else if (digits[i] == 6)
                sum += 3;
            else if (digits[i] == 7)
                sum += 5;
            else if (digits[i] == 8)
                sum += 7;
            else if (digits[i] == 9)
                sum += 9;
        }
        for (int i = digits.length - 1; i >= 0; i -= 2) {
            sum += digits[i];
        }
        if (sum % 10 == 0) {
            if (digits[0] == 3)
                System.out.println("AMERICAN EXPRESS");
            else if (digits[0] == 4)
                System.out.println("VISA");
            else if (digits[0] == 5)
                System.out.println("MASTERCARD");
        }
        else
            System.out.println("INVALID CARD NUMBER!!!");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please input the number of your credit card: ");
        String number = bufferedReader.readLine();
        number = number.replaceAll("\\D+","");
        if (number.length() != 13 && number.length() != 15 && number.length() != 16) {
            System.out.println("INVALID CARD NUMBER!!!");
        }
        else if (number.length() == 13 && number.charAt(0) != '4') {
            System.out.println("INVALID CARD NUMBER!!!");
        }
        else if (number.length() == 15 && !number.substring(0, 2).equals("34") &&
                !number.substring(0, 2).equals("37")) {
            System.out.println("INVALID CARD NUMBER!!!");
        }
        else if (number.length() == 16 && number.charAt(0) != '4' &&
                !number.substring(0, 2).equals("51") && !number.substring(0, 2).equals("52") &&
                !number.substring(0, 2).equals("53") && !number.substring(0, 2).equals("54") &&
                !number.substring(0, 2).equals("55")) {
            System.out.println("INVALID CARD NUMBER!!!");
        }
        else {
            luhns(Long.parseLong(number));
        }
    }
}
