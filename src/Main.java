import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String calc(String input) throws Exception {
        String expression_gapless = input.replaceAll("\\s", "");
        Pattern arab1 = Pattern.compile("(0|[1-9]\\d{0,100})[\\+,\\-,\\*,\\/](0|[1-9]\\d{0,100})");
        Matcher arab2 = arab1.matcher(expression_gapless);
        if (arab2.matches()) {
            String[] arr_arab_digit = expression_gapless.split("([\\+\\-\\*\\/])");
            int arab_digit_int1 = 0;
            int arab_digit_int2 = 0;
            try {
                arab_digit_int1 = Integer.parseInt(arr_arab_digit[0]);
                arab_digit_int2 = Integer.parseInt(arr_arab_digit[1]);
            } catch (NumberFormatException e) {
                throw new Exception("ввод арабских цифр за пределами диапазона калькулятора");
            }
            Pattern path1 = Pattern.compile("([\\+\\-\\*\\/])");
            Matcher operator1 = path1.matcher(expression_gapless);
            operator1.find();
            String r1 = operator1.group();
            if(1 <= arab_digit_int1 && arab_digit_int1 <= 10 && 1 <= arab_digit_int2 && arab_digit_int2 <= 10) {
                int answer = 0;
                switch (r1) {
                    case "+":
                        answer = arab_digit_int1 + arab_digit_int2;
                        break;
                    case "-":
                        answer = arab_digit_int1 - arab_digit_int2;
                        break;
                    case "*":
                        answer = arab_digit_int1 * arab_digit_int2;
                        break;
                    case "/":
                        answer = Math.round(arab_digit_int1 / arab_digit_int2);
                        break;
                }
                return "ввод: " + expression_gapless + "\nответ: " + Integer.toString(answer);
            }
            else throw new Exception("ввод арабских цифр за пределами диапазона калькулятора");
        }
        else throw new Exception("введенное выражение не соответсвует требованиям условий ввода");
    }

    public static void main(String[] args) throws Exception {
        while(true){
            System.out.println("введите выражение сложения, вычитания, умножения или деления двух чисел");
            Scanner input = new Scanner(System.in);
            String expression = input.nextLine();
            System.out.println(calc(expression));
        }
    }
}





