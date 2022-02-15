import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TemperatureCalculator
{
    public static void main(String[] args)
    {
        boolean exit = false;
        boolean firstOrSecond;
        int firstChoose, secondChoose;
        Scanner keyboard = new Scanner(System.in);
        String read;

        Map<Integer, String> scale = new HashMap<>();
        scale.put(1, "Celsius");
        scale.put(2, "Kelvin");
        scale.put(3, "Fahrenheit");
        scale.put(4, "Rankine");
        scale.put(5, "Romer");
        scale.put(6, "Newton");
        scale.put(7, "Delisle");
        scale.put(8, "Reamur");

        do {
            System.out.println("Witam w programie służacym do przeliczania skal temperatury. " +
                    "\nJeżeli chcesz zakończyć działanie programu wciśnij 'q'");

            firstChoose = 0;
            secondChoose = 0;
            firstOrSecond = true;
            showMenu(firstOrSecond, firstChoose, scale);

            read = keyboard.nextLine();

            if(read.equalsIgnoreCase("q"))
                exit = true;
            else
            {
                firstChoose = Integer.parseInt(read);
                firstOrSecond = false;
                showMenu(firstOrSecond, firstChoose, scale);

                read = keyboard.nextLine();
                secondChoose = Integer.parseInt(read);
            }
        }while(!exit);

        keyboard.close();
    }

    public static void showMenu(boolean firstOrSecond, int firstChoose, Map<Integer, String> scale)
    {

        if(firstOrSecond)
        {
            for(Integer key : scale.keySet())
                System.out.println(key + "  -  " + scale.get(key));
        }
        else
        {
            for(Integer key : scale.keySet())
            {
                if(key == firstChoose)
                    continue;
                else
                    if(key < firstChoose)
                        System.out.println(key + "  -  " + scale.get(key));
                    else
                        System.out.println(key-1 + "  -  " + scale.get(key));
            }
        }
    }
}
