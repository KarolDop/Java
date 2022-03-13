package palindrom;

import java.util.Scanner;

public class palindromNumber
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String read;
        int number;
        boolean exit = false;

        do {
            System.out.println("Jeżeli chcesz zakończyć wciśnij q.");
            System.out.print("Podaj liczbę naturalną: ");

            if(keyboard.hasNextInt())
            {
                number = keyboard.nextInt();
                keyboard.nextLine();

                if(isPalindrome(number))
                    System.out.println("Podana przez ciebie liczba jest palndromem");
                else
                    System.out.println("Podaja przez ciebie liczba nie jest palindromem");
            }
            else
            {
                read = keyboard.nextLine();
                read = read.toLowerCase();
                if(read.length() == 1 && read.charAt(0) == 'q')
                    exit = true;
                else
                    System.out.println("Podałeś niewłaściwe dane spróbuj raz jeszcze.");
            }

        }while(!exit);
    }

    public static int reverse(int number)
    {
        String normal;
        String reverse = "";
        int reverseInt;

        normal = Integer.toString(number);

        for(int i = normal.length() - 1; i >= 0 ;i--)
        {
            reverse += Character.toString(normal.charAt(i));
        }

        reverseInt = Integer.parseInt(reverse);

        return reverseInt;
    }

    public static boolean isPalindrome(int number)
    {
        boolean isPalidrome = false;

        if(number == reverse(number))
            isPalidrome = true;

        return isPalidrome;
    }
}
