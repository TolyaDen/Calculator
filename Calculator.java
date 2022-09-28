import java.util.Scanner;

public class Calculator {

    static String[] arrayRim = {
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) {

        System.out.print("Выражение: ");

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Результат: " + calc(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Ошибка ввода");
        }
    }

    public static String calc(String input) throws Exception {

        String output;

        String[] array = input.split((" "));

        String strA = array[0];
        String sign = array[1];
        String strB = array[2];

        // Проверка и вычисление выражения с арабскими цифрами

        if ((strA.equals("1") || strA.equals("2") || strA.equals("3")
                || strA.equals("4") || strA.equals("5") || strA.equals("6")
                || strA.equals("7") || strA.equals("8") || strA.equals("9")
                || strA.equals("10"))
                && (strB.equals("1") || strB.equals("2") || strB.equals("3")
                || strB.equals("4") || strB.equals("5") || strB.equals("6")
                || strB.equals("7") || strB.equals("8") || strB.equals("9")
                || strB.equals("10"))) {

            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            output = String.valueOf(resolve(a, sign, b));
        }

        // Проверка и вычисление выражения с римскими цифрами

        else if ((strA.equals("I") || strA.equals("II") || strA.equals("III")
                || strA.equals("IV") || strA.equals("V") || strA.equals("VI")
                || strA.equals("VII") || strA.equals("VIII") || strA.equals("IX")
                || strA.equals("X"))
                && (strB.equals("I") || strB.equals("II") || strB.equals("III")
                || strB.equals("IV") || strB.equals("V") || strB.equals("VI")
                || strB.equals("VII") || strB.equals("VIII") || strB.equals("IX")
                || strB.equals("X"))) {

            int a = findRim(strA);
            int b = findRim(strB);
            int index = resolve(a, sign, b);

            output = String.valueOf(arrayRim[index - 1]);
        } else {
            throw new Exception();
        }
        return output;
    }

    // Преобразование римских чисел в арабские

    static int findRim(String str) {

        int output = 0;

        for (int i = 0; i < arrayRim.length; i++) {
            if (str.equals(arrayRim[i])) {
                output = i + 1;
            }
        }
        return output;
    }

    // Общий для арабских и римских цифр метод вычисления

    static int resolve(int a, String sign, int b) throws Exception {

        int output;

        switch (sign) {
            case "+":
                output = a + b;
                break;
            case "-":
                output = a - b;
                break;
            case "*":
                output = a * b;
                break;
            case "/":
                output = a / b;
                break;
            default:
                throw new Exception();
        }
        return output;
    }
}