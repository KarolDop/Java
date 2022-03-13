public class CurrentDataAndTime
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
        long currentTime = System.currentTimeMillis();
        System.out.println(currentData(currentTime) + " " + currentTime(currentTime));
    }

    public static String currentTime(long time)
    {
        long totalSecond = time / 1000;
        long currentSecond = totalSecond % 60;

        long totalMinute = totalSecond / 60;
        long currentMinute = totalMinute % 60;

        long totalHours = totalMinute / 60;
        long currentHours = (totalHours % 24) + 1;

        return (currentHours + ":" + currentMinute + ":" + currentSecond);
    }

    public static String currentData(long time)
    {
        int actualYear = 1970;
        int actualMonth = 1;
        String actualMonthString;

        long totalDays = totalDay(time);
        long daysInLastYear = 0;

        int dayInYear = 365;

        for(int i = (int)totalDays; i >= dayInYear; )
        {
            if (((actualYear % 4 == 0) && (actualYear % 100 != 0) || (actualYear % 400 == 0)))
            {
                i -= 366;
                dayInYear = 366;
            }
            else
            {
                i -= 365;
                dayInYear = 365;
            }
            actualYear++;
            daysInLastYear = i;
        }

        for(Months kal : Months.values())
        {
            if(daysInLastYear < kal.getDay() || dayInYear < kal.getDay() + 1 && ((actualYear % 4 == 0) && (actualYear % 100 != 0) || (actualYear % 400 == 0)))
                break;

            if(kal.getValue() == 2 && ((actualYear % 4 == 0) && (actualYear % 100 != 0) || (actualYear % 400 == 0)))
            {
                actualMonth++;
                daysInLastYear -= 29;
            }

            actualMonth++;
            daysInLastYear -= kal.getDay();
        }

        actualMonthString = actualMonth(actualMonth);

        return (daysInLastYear + " " + actualMonthString + " " + actualYear);
    }

    public static int totalDay(long time)
    {
        long totalSecond = time / 1000;

        long totalMinute = totalSecond / 60;

        long totalHours = (totalMinute / 60) + 1;

        long totalDays = (totalHours / 24) + 1;

        return (int)totalDays;
    }

    public static String actualMonth(int month)
    {
        switch (month)
        {
            case 1:
                return "Styczeń";
            case 2:
                return "Luty";
            case 3:
                return "Marzec";
            case 4:
                return "Kwiecień";
            case 5:
                return "Maj";
            case 6:
                return "Czerwiec";
            case 7:
                return "Lipiec";
            case 8:
                return "Sierpień";
            case 9:
                return "Wrzesień";
            case 10:
                return "Październik";
            case 11:
                return "Listopad";
            case 12:
                return "Grudzień";
        }
        return "";
    }
}