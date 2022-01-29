import java.util.Scanner;

public class CalculatorCheck
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int firstNumber = 0, secendNumber = 0;
        boolean firstTest = false, secendTest = false;
        String odczyt;
        do {
            System.out.print("Podaj pierwszą liczbę: ");
            odczyt = keyboard.nextLine();
            if (odczyt.matches("\\d") || odczyt.matches("-[1-9]"))
            {
                firstNumber = Integer.valueOf(odczyt);
                firstTest = true;
            }
        }while (!firstTest);

        do {
            System.out.print("Podaj drugą liczbę: ");
            odczyt = keyboard.nextLine();
            if (odczyt.matches("\\d") || odczyt.matches("-[1-9]"))
            {
                secendNumber = Integer.valueOf(odczyt);
                secendTest = true;
            }
        }while (!secendTest);

        CalculatorMethod calc = new CalculatorMethod(firstNumber, secendNumber);

        System.out.println(calc.plus());
        System.out.println(calc.minus());
        System.out.println(calc.multiplay());
        System.out.println(calc.divided());
        System.out.println(calc.modulo());
    }
}
