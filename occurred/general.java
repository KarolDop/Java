package occurred;

import java.util.HashSet;
import java.util.Set;

public class general
{
    public static void main(String[] args)
    {
        int[] table = new int[] {1, 2, 3, 1};
        Set<Integer> nonOccurred = new HashSet<>();
        int index = 0;

        ArrayOccurred list = new ArrayOccurred(table);

        nonOccurred = list.nonOccurredNumber();
        int[][] quantity = new int[2][nonOccurred.size()];

        quantity = list.howManyOccurred();
        System.out.println("Liczba:     Wystąpienia:");
        for(int i = 0; i < quantity[0].length; i++)
        {
            System.out.println(quantity[0][i] + "           " + quantity[1][i]);
        }
    }
}
