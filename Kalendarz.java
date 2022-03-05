import java.util.Scanner;

public class Kalendarz
{
    public enum Months
    {
        Styczen(1, 31),
        Luty(2, 28),
        Marzec(3, 31),
        Kwiecien(4, 30),
        Maj(5, 31),
        Czerwiec(6, 30),
        Lipiec(7, 31),
        Sierpien(8, 31),
        Wrzesien(9, 30),
        Październik(10, 31),
        Listopad(11, 30),
        Grudzień(12, 31);

        private int value;
        private int day;

        private Months(int value, int day)
        {
            this.value = value;
            this.day = day;
        }

        public int getValue()
        {
            return value;
        }

        public int getDay()
        {
            return day;
        }
    }

    public static void main(String[] args)
    {
        String head = "";
        String line = "------------------------------------------";
        String firstDay;
        int year;
        int middleLine;
        int day = 0;
        boolean isLeap = false;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Podaj rok: ");
        year = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Podaj dzien tygodnia: ");
        firstDay = keyboard.nextLine();

        if(year % 4 == 0)
            isLeap = true;

        if (year % 100 == 0)
            {
                if (year % 400 == 0)
                    isLeap = true;
                else
                    isLeap = false;
            }

        for(int j = 1; j <= 12; j++)
        {
            for(Months kal : Months.values())
            {
                if(j == kal.getValue())
                {
                    head = kal.toString() + " " + year;
                    day = kal.getDay();

                    if(isLeap && kal.getValue() == 2)
                        day = 29;
                }
            }

            System.out.printf("%" + ((line.length()/2) + (head.length()/2)) +"s\n", head);
            System.out.println(line);
            System.out.printf("%6s%6s%6s%6s%6s%6s%6s\n", "Niedź.", "Pon.", "Wt.", "Śr.", "Czw.", "Pt.", "Sob.");
            for (int i = 1; i <= day; i++)
            {
                if (i == 1) {
                    switch (firstDay) {
                        case "Niedziela":
                            System.out.printf("%6d", i);
                            firstDay = "Poniedzialek";
                            break;
                        case "Poniedzialek":
                            System.out.printf("%12d", i);
                            firstDay = "Wtorek";
                            break;
                        case "Wtorek":
                            System.out.printf("%18d", i);
                            firstDay = "Sroda";
                            break;
                        case "Sroda":
                            System.out.printf("%24d", i);
                            firstDay = "Czwartek";
                            break;
                        case "Czwartek":
                            System.out.printf("%30d", i);
                            firstDay = "Piatek";
                            break;
                        case "Piatek":
                            System.out.printf("%36d", i);
                            firstDay = "Sobota";
                            break;
                        case "Sobota":
                            System.out.printf("%42d\n", i);
                            firstDay = "Niedziela";
                            break;
                    }
                } else {
                    switch (firstDay) {
                        case "Niedziela":
                            System.out.printf("%6d", i);
                            firstDay = "Poniedzialek";
                            break;
                        case "Poniedzialek":
                            System.out.printf("%6d", i);
                            firstDay = "Wtorek";
                            break;
                        case "Wtorek":
                            System.out.printf("%6d", i);
                            firstDay = "Sroda";
                            break;
                        case "Sroda":
                            System.out.printf("%6d", i);
                            firstDay = "Czwartek";
                            break;
                        case "Czwartek":
                            System.out.printf("%6d", i);
                            firstDay = "Piatek";
                            break;
                        case "Piatek":
                            System.out.printf("%6d", i);
                            firstDay = "Sobota";
                            break;
                        case "Sobota":
                            System.out.printf("%6d\n", i);
                            firstDay = "Niedziela";
                            break;
                    }
                }
            }
            System.out.println("\n");
        }
    }
}