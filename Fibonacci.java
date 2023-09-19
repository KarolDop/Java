import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int sequenceNumber = 0;

        System.out.print("Podaj element ciągu fibonacci'ego którego wartość chcesz: ");
        try
        {
            sequenceNumber = keyboard.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Podałeś inną wartość niż liczba rzeczywista");
            System.exit(0);
        }
        System.out.printf("Ciąg Fibonacci'ego dla %d wynosi: %d", sequenceNumber, fibonacciValue(sequenceNumber));

    }

    public static long fibonacciValue(int sequenceNumber)
    {
        long value = 1L;
        long first = 1L;
        long second = 1L;
        long temp;

        if(sequenceNumber == 1 || sequenceNumber == 2)
            value = 1;
        else
        {
            for(int i = 3; i <= sequenceNumber; i++)
            {
                value = first + second;
                temp = first;
                first = value;
                second = temp;
            }
        }

        return value;
    }
}
