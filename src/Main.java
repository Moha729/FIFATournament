import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Menus menus = new Menus();

    public static final String INTROTEXT = "Velkommen til din FIFA22 Tunering";
    public static final String MENU1 = "press 1 - Opret ny tunering";
    public static final String MENU2 = "press 2 - Load en tunering";

    public static final String MENU3 = "press 1 - Tilfoej spiller";
    public static final String MENU4 = "press 2 - Videre til tunering";

    public static final String MENU5 = "Giv tuneringen et navn";

    static Scanner scan = new Scanner(System.in);

    static ProgramBody body = new ProgramBody();

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(menus.welcomeText(INTROTEXT));
        System.out.print(menus.menu1(MENU1, MENU2));

        while (!scan.hasNextInt() /*|| console.nextInt() !=1 || console.nextInt() !=2*/) {
            scan.next(); //to discard the input
            System.out.println("Not valid answer! Try again please!");
            System.out.print(menus.menu1(MENU1, MENU2));
        }

        switch (scan.nextInt()){
            case 1 -> body.createNewTournament();
            case 2 -> body.loadExistingTournament();
        }


    }
}
