import java.util.Scanner;

public class PasswordCheck
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String pass;
        int numberInPass = 0;
        int numberOrLetter = 0;

        System.out.println("Hasło musi spełniać następujące warunki:");
        System.out.println("a) Hasło musi zawierać przynajmniej 8 znaków");
        System.out.println("b) Hasło musi się składać tylko z liter i cyfr");
        System.out.println("c) Hasło musi zawierać przynajmniej 2 cyfry");
        System.out.print("Podaj nowe hasło: ");
        pass = keyboard.nextLine();

        if(!conditionA(pass))
            System.out.println("Nie spełniłeś warunku a)");
        if(!conditionB(pass))
            System.out.println("Nie spełniłeś warunku b)");
        if(!conditionC(pass))
            System.out.println("Nie spełniłeś warunku c)");

        if(conditionA(pass) && conditionB(pass) && conditionC(pass))
            System.out.println("Ustanowiłeś nowe hasło");
    }

    public static boolean conditionA(String pass)
    {
        if(pass.length() < 8)
            return false;
        return true;
    }

    public static boolean conditionB(String pass)
    {
        int numberOrLetter = 0;
        for(int i = 0; i < pass.length(); i++)
        {
            if(pass.charAt(i) >= 48 && pass.charAt(i) <= 57 || pass.charAt(i) >= 65 && pass.charAt(i) <= 90 || pass.charAt(i) >= 97 && pass.charAt(i) <= 122 )
                numberOrLetter++;
        }

        if(numberOrLetter != pass.length())
            return false;
        return true;
    }

    public static boolean conditionC(String pass)
    {
        int numberInPass = 0;

        for(int i = 0; i < pass.length(); i++)
        {
            if(pass.charAt(i) >= 48 && pass.charAt(i) <= 57)
                numberInPass++;
        }

        if(numberInPass < 2)
            return false;
        return true;
    }
}
