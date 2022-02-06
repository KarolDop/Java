package palindrom;

import java.util.Locale;
import java.util.Scanner;

public class test
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String sentence;
        boolean exit = false;

        System.out.println("Podaj ciąg który jest według ciebie palindromem: ");
        Palindrom palindrom = new Palindrom();
        do {
            sentence = keyboard.nextLine();

            if(sentence.length() == 1 && sentence.equalsIgnoreCase("q"))
            {
                exit = true;
                continue;
            }

            palindrom.setSentence(sentence);
            palindrom.sentenceToLower();
            palindrom.removeWhitespace();

            if (palindrom.isPalindrome())
                System.out.println("Wprowadzony ciąg jest palindromem");
            else
                System.out.println("Wprowadzony ciąg nie jest palndromem");

            System.out.println("Podaj ciąg który jest według ciebie palindromem: ");
            System.out.println("Jeżeli chcesz zakończyć wpisz \"q\"");
        }while(!exit);

        keyboard.close();
    }
}
