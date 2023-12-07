import javax.swing.*;
import java.io.File;  // Import the File class
import java.io.IOException;

public class Main {
    public static void main(String[] args) {//main driver class
        MainMenu mainMenu = new MainMenu();
        try {
            File customerStorage = new File("customerStorage.txt");
            if (customerStorage.createNewFile()) {
                System.out.println("File Created:" + customerStorage.getName());
            } else {
                System.out.println();
            }
        }catch (IOException e) {
            System.out.println("Error has occured.");
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {//setup to where this is where the windows start and the objects above are instantiated for use in the program
                mainMenu.createUIComponents();
            }
        });
    }
}