import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IOfunctions{
    public static void Show_Menu(){ //Realiza a leitura do menu através de um TXT
        File file = new File("menu.txt");

        try {
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine()) System.out.println(scan.nextLine());

            scan.close();
        } catch (FileNotFoundException err){
            System.out.println("Error opening file:" + err.getMessage());
        }
    }

    public static int choice(){ //Salva a choice do usuario
        Show_Menu();
		Scanner input = new Scanner(System.in);
		System.out.print("\n          Enter an option: ");
        int choice = Integer.parseInt(input.nextLine());
		while(choice > 7 || choice < 1){
            Show_Menu();
			System.out.print("\nInvalid option, type again: ");
			choice = input.nextInt();
		}
		return choice;
    }
}