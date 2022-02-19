package Function;

import java.util.Scanner;

public class function
{
    static Linear linear = new Linear();

    public enum functionTyp
    {
        LINEAR(1),
        QUADRATIC(2);

        private int value;

        private functionTyp(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String inString;
        int choose = 0;
        boolean exit = false;
        functionTyp functionChoosen = functionTyp.LINEAR;

        do {
            menu();

            if (keyboard.hasNextInt())
            {
                choose = keyboard.nextInt();

                if(choose < 1 || choose > maxValue())
                {
                    System.out.println("\nYou choose value from out of rannge. Try once agarin\n");
                }
                else
                {
                    functionChoosen = fromIntToEnum(choose);
                    pickBySwitch(functionChoosen, keyboard);
                }
            }
            else if (keyboard.hasNext())
            {
                inString = keyboard.nextLine();

                if(inString.equalsIgnoreCase("q"))
                    exit = true;
            }
            } while (!exit);

        keyboard.close();
        System.out.println("\nThanks for use program. See you soon!");
        }

//Metoda wyświetla menu programu. W oparciu o tryb wyliczeniowy zadeklarowany na początku kodu

    public static void menu()
    {
        System.out.println("For exit program write: \"q\".");
        System.out.println("Choose type of fuction that you want calculate: ");
        for (functionTyp function : functionTyp.values())
        {
            System.out.println(function.getValue() + " - " + function);
        }
    }

//Metoda wyszukuje maksymalną ilość rodzaju równań jakie są aktualnie obsługiwane.

    public static int maxValue()
    {
        int max = 0;

        for(functionTyp fuction : functionTyp.values())
        {
            if(fuction.getValue() > max)
                max = fuction.getValue();
        }
        return max;
    }

//Metoda konwetuje wybrany numer równania do tryby wyliczeniowego

    public static functionTyp fromIntToEnum(int choose)
    {
        String typ = "";
        for(functionTyp function : functionTyp.values())
        {
            if(choose == function.getValue())
                typ = function.toString();        }
      return functionTyp.valueOf(typ);
    }

//Metoda wybiera za pomocą instrukcji switch odpowiednie równanie

    public static void pickBySwitch(functionTyp equationChoosen, Scanner keyboard)
    {
        switch(equationChoosen)
        {
            case LINEAR:
                System.out.print("Set A value: ");
                linear.setA(checkIfDouble(keyboard));
                System.out.print("Set B value: ");
                linear.setB(checkIfDouble(keyboard));
                linear.linearDirection();
                if(linear.getDirection() == 0 && linear.getB() != 0)
                {
                    System.out.println("Function are constant and don't have zero place");
                }
                else if(linear.getDirection() == 0 && linear.getB() == 0)
                {
                    System.out.println("Function are constant and have infinity zero place");
                }
                else if(linear.getDirection() == 1)
                {
                    System.out.println("Function are ascending.");
                    linear.zeroPlace();
                }
                else if(linear.getDirection() == -1)
                {
                    System.out.println("Function are descending.");
                    linear.zeroPlace();
                }
                System.out.println();
                break;
            case QUADRATIC:
                System.out.println(2);
                break;
        }
    }

// Metoda sprawdza czy wprowadzona wartość jest zmiennoprzecinkowa

    public static double checkIfDouble(Scanner keyboard)
    {
        double temp = 0;
        boolean flag = true;

        do{
            if(keyboard.hasNextDouble())
            {
                temp = keyboard.nextDouble();
                flag = false;
            }
            else
                System.out.println("Try once again");
        }while(flag);

        return temp;
    }
}