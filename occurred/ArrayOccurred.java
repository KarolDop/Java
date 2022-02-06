package occurred;

import java.util.HashSet;
import java.util.Set;

public class ArrayOccurred
{
    private int[] table;
    private Set<Integer> nonOccurred = new HashSet<>();
    private int[][] howMany;

    ArrayOccurred(int[] table)
    {
        this.table = table;
    }

    public Set<Integer> nonOccurredNumber()
    {
        for(int i = 0; i < table.length; i++)
            nonOccurred.add(table[i]);

        return nonOccurred;
    }

    public int[][] howManyOccurred()
    {
        int counter;
        int indexOfHowManyArray = 0;
        howMany = new int[2][nonOccurred.size()];

        for(Integer number : nonOccurred)
        {
            counter = 0;
            for (int i = 0; i < table.length; i++)
            {
                if(number == table[i])
                    counter++;
            }
            howMany[0][indexOfHowManyArray] = number;
            howMany[1][indexOfHowManyArray] = counter;
            indexOfHowManyArray++;
        }

        return howMany;
    }

    public int[] getTable()
    {
        return table;
    }

    public void setTable(int[] table)
    {
        this.table = table;
    }

    public int[][] getHowMany()
    {
        return howMany;
    }

    public Set<Integer> getNonOccurred()
    {
        return nonOccurred;
    }
}
