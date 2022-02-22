import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Merge
{
    public static void main(String[] args)
    {
        ProcessBuilder mergeFile = new ProcessBuilder();
        String directory, command;
        int fileNumber;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter path to the file: ");
        directory = keyboard.nextLine();

        System.out.print("What number have last file: ");
        fileNumber = keyboard.nextInt();

        mergeFile.directory(new File(directory));

        try {
            command = "type PERFLOG0.xml > PERFLOG.xml";
            mergeFile.command("cmd.exe", "/c", command);
            Process process = mergeFile.start();

                for(int i = 1; i <= fileNumber; i++)
                {
                    command = "type PERFLOG" + i +".xml >> PERFLOG.xml";
                    mergeFile.command("cmd.exe", "/c", command);
                    process = mergeFile.start();
                }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}