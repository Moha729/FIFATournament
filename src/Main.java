import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {//Programmet er færdigt og kan bruges men kræver formattering og massering

    public static final String INTROTEXT = "Velkommen til din FIFA22 Tunering";
    public static final String BOX1_1 = " -----------------------------------------------------------------------------------------------";
    public static final String BOX1_2 = "|                                                                                               |";
    public static final String BOX2_1 = " -----------------------------------------------";
    public static final String BOX2_2 = "|                                               |";


    public static void main(String[] args) throws FileNotFoundException {

        String menu1 = "press 1 - Opret ny tunering";
        String menu2 = "press 2 - Load en tunering";

        String menu3 = "press 1 - Tilfoej spiller";
        String menu4 = "press 2 - Videre til tunering";

        String menu5 = "Giv tuneringen et navn";

        //Presentation + First Menu (new or load).
        System.out.printf("%s\n%s\n|\t\t\t\t\t\t\t\t%35s\t\t\t\t\t\t\t\t|\n%s\n%s\n", BOX1_1, BOX1_2, INTROTEXT, BOX1_2, BOX1_1);
        System.out.printf("%s%s\n|\t\t\t%s\t\t\t||\t\t\t%s\t\t\t|\n%s%s", BOX2_1, BOX2_1, menu1, menu2, BOX2_1, BOX2_1);

        //Constructors
        Scanner console = new Scanner(System.in);

        ArrayList<Player> players = new ArrayList<>();

        ArrayList<Match> unplayedMatches = new ArrayList<>();

        ArrayList<MatchPlayed> playedMatches = new ArrayList<>();

        //Robusting the program //Not totally good yet (!= 1 && 2).
        while (!console.hasNextInt() /*|| console.nextInt() !=1 || console.nextInt() !=2*/) {
            console.next(); //to discard the input
            errorMessage1(menu1, menu2);
        }

        if (console.nextInt() == 1) {
            console.nextLine();
            System.out.print("Er du sikker? Gamle data vil blive tabt - press 1");
            //Robusting the program //Not totally good yet (!= 1 && 2).
            while (!console.hasNextInt() /*|| console.nextInt() !=1 || console.nextInt() !=2*/) {
                console.next(); //to discard the input
                System.out.println("Not valid answer! Try again please!");
                System.out.print("Er du sikker? Gamle data vil blive tabt - press 1");
            }

            if (console.nextInt() == 1) {//Creating a new tournament

                //enter name for tournament
                //System.out.printf("\n%s\n|\t\t\t  %s  \t\t\t|\n%s\n", BOX2_1, menu5, BOX2_1);
                //System.out.print("|\t\t\t\t  ");
                //String tournamentName = console.next();


                newPlayer(console, players);
                do {
                    newPlayer(console, players);

                    System.out.printf("%s%s\n|\t\t\t%s\t\t\t||\t\t\t%s\t\t|\n%s%s", BOX2_1, BOX2_1, menu3, menu4, BOX2_1, BOX2_1);
                    while (!console.hasNextInt() /*|| console.nextInt() !=1 || console.nextInt() !=2*/) {
                        console.next(); //to discard the input
                        System.out.println("Not valid answer! Try again please!");
                    }
                    save(players);

                } while (console.nextInt() == 1);

                //Tuneringen starter her
                saveComming(unplayedMatches);
                showTable(players);
                makeMatches(players, unplayedMatches);
                selectMatch(unplayedMatches, playedMatches, console, players);
                //registrateResult();


            } else {//just load an old tournament

            }

        } else if (console.nextInt() == 2) {//Load an old tournament

            Scanner fileScan = new Scanner(new File("Table.txt"));

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();

                Scanner lineScan = new Scanner(line);

                String name = lineScan.next();
                int matches = lineScan.nextInt();
                int points = lineScan.nextInt();
                int wins = lineScan.nextInt();
                int draws = lineScan.nextInt();
                int lose = lineScan.nextInt();
                int goalsFor = lineScan.nextInt();
                int goalsAgainst = lineScan.nextInt();
                int goalsDifference = lineScan.nextInt();

                players.add(new Player(name, matches, points, wins, draws, lose, goalsFor, goalsAgainst, goalsDifference));

            }

            Scanner fileScan2 = new Scanner(new File("Matches.txt"));
/*
            while (fileScan2.hasNextLine()){
                String line = fileScan2.nextLine();

                Scanner lineScan2 = new Scanner(line);

                String player1 = lineScan2.next();
                String vs = lineScan2.next();
                String player2 = lineScan2.next();

                unplayedMatches.add(new Match(new Player(player1), new Player(player2)));
*/
            }

            //load played metches
            showPlayedMatched(playedMatches);
            showTable(players);
            //load matches
            //makeMatches(players, unplayedMatches);
            selectMatch(unplayedMatches, playedMatches, console, players);


        } //else {        }




    public static void save(ArrayList<Player> players) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Table.txt"));
        for (int i = 0; i < players.size(); i++) {
            output.printf("%10s %3d %3d %4d %3d %3d %5d %3d %3d\n", players.get(i).getName(), players.get(i).getM(),
                    players.get(i).getP(),
                    players.get(i).getW(), players.get(i).getD(), players.get(i).getL(), players.get(i).getGf(),
                    players.get(i).getGa(), players.get(i).getGd());
        }


    }
    public static void savePlayed(ArrayList<MatchPlayed> played)throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("Played.txt"));
        for (int i = 0; i < played.size(); i++){
            output.println(played.get(i));
        }

    }

    public static void saveComming(ArrayList<Match> matches)throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("Matches.txt"));
        for (int i = 0; i < matches.size(); i++){
            output.println(matches.get(i));
        }

    }

    public static void showPlayedMatched(ArrayList<MatchPlayed> playedMatches) {
        System.out.println(BOX2_1);
        for (int i = 0; i < playedMatches.size(); i++) {
            System.out.printf("|\t\t %s \t\t\t|\n", playedMatches.get(i));
        }
        System.out.print(BOX2_1);
    }

    public static void registrateMatch(int i, ArrayList<Match> unplayed, ArrayList<MatchPlayed> playedMatches, Scanner scan, ArrayList<Player> players) throws FileNotFoundException {

       String resultWhat = "What is the result?";
        System.out.printf("%s\n|\t\t\t %20s \t\t %-10s vs. %10s", BOX1_1, resultWhat, unplayed.get(i - 1).getPlayer1(), unplayed.get(i - 1).getPlayer2());

        System.out.print("\n|\t"+unplayed.get(i - 1).getPlayer1() + ":_");
        int res1 = scan.nextInt();
        System.out.print("|\t"+unplayed.get(i - 1).getPlayer2() + ":_");
        int res2 = scan.nextInt();
        System.out.println(BOX1_1);

        //increment matches played
        unplayed.get(i - 1).getPlayer1().setM(unplayed.get(i - 1).getPlayer1().getM() + 1);
        unplayed.get(i - 1).getPlayer2().setM(unplayed.get(i - 1).getPlayer2().getM() + 1);


        if (res1 > res2) {//player 1 wins
            //update points
            unplayed.get(i - 1).getPlayer1().setP(unplayed.get(i - 1).getPlayer1().getP() + 3);// increment by 3

            //win / lose
            unplayed.get(i - 1).getPlayer1().setW(unplayed.get(i - 1).getPlayer1().getW() + 1);// + 1 win
            unplayed.get(i - 1).getPlayer2().setL(unplayed.get(i - 1).getPlayer2().getL() + 1);// + 1 lose


        } else if (res1 < res2) {//player 1 loses
            //update points
            unplayed.get(i - 1).getPlayer2().setP(unplayed.get(i - 1).getPlayer2().getP() + 3);// increment by 3

            //win / lose
            unplayed.get(i - 1).getPlayer2().setW(unplayed.get(i - 1).getPlayer2().getW() + 1);// + 1 win
            unplayed.get(i - 1).getPlayer1().setL(unplayed.get(i - 1).getPlayer1().getL() + 1);// + 1 lose

        } else {//draw
            //update points
            unplayed.get(i - 1).getPlayer1().setP(unplayed.get(i - 1).getPlayer1().getP() + 1);// increment by 1
            unplayed.get(i - 1).getPlayer2().setP(unplayed.get(i - 1).getPlayer2().getP() + 1);// increment by 1

            //draw
            unplayed.get(i - 1).getPlayer1().setD(unplayed.get(i - 1).getPlayer1().getD() + 1);// increment by 1
            unplayed.get(i - 1).getPlayer2().setD(unplayed.get(i - 1).getPlayer2().getD() + 1);// increment by 1

        }
        //goals
        unplayed.get(i - 1).getPlayer1().setGf(unplayed.get(i - 1).getPlayer1().getGf() + res1);// goal for 1
        unplayed.get(i - 1).getPlayer1().setGa(unplayed.get(i - 1).getPlayer1().getGa() + res2);// against 1

        unplayed.get(i - 1).getPlayer2().setGf(unplayed.get(i - 1).getPlayer2().getGf() + res2);// goal for 2
        unplayed.get(i - 1).getPlayer2().setGa(unplayed.get(i - 1).getPlayer2().getGa() + res1);// against 2

        //goal difference
        unplayed.get(i - 1).getPlayer1().setGd(unplayed.get(i - 1).getPlayer1().getGf() - unplayed.get(i - 1).getPlayer1().getGa());
        unplayed.get(i - 1).getPlayer2().setGd(unplayed.get(i - 1).getPlayer2().getGf() - unplayed.get(i - 1).getPlayer2().getGa());

        playedMatches.add(new MatchPlayed(unplayed.get(i - 1).getPlayer1(), unplayed.get(i - 1).getPlayer2(), res1, res2));
        unplayed.remove(i - 1);

        save(players);
        savePlayed(playedMatches);
        saveComming(unplayed);

        showPlayedMatched(playedMatches);
        showTable(players);
        selectMatch(unplayed, playedMatches, scan, players);
    }

    public static void selectMatch(ArrayList<Match> unplayedMatches, ArrayList<MatchPlayed> playedMatches, Scanner scan, ArrayList<Player> players) throws FileNotFoundException {
        System.out.println(BOX2_1);
        for (int i = 0; i < unplayedMatches.size(); i++) {
            System.out.println("|\t "+(i + 1) + "\t\t" + unplayedMatches.get(i)+"\t\t\t|");
            System.out.println(BOX2_1);
        }
        //System.out.println(BOX2_1);
        String chooseGame = "Choose match";
        System.out.printf("\n%s\n|\t\t\t\t  %s  \t\t\t\t|\n%s", BOX2_1, chooseGame, BOX2_1);
        //make a robustance
        int index = scan.nextInt();
        registrateMatch(index, unplayedMatches, playedMatches, scan, players);
    }

    public static void makeMatches(ArrayList<Player> players, ArrayList<Match> unplayedMatches) {
        int y = players.size();
        int i = 0;
        int j = y - (y - (i + 1));

        for (i = 0; i < (y - 1); i++) {
            for (j = y - (y - (i + 1)); j < y; j++) {
                //System.out.println(players.get(i) + " vs. " + players.get(j));
                unplayedMatches.add(new Match(players.get(i), players.get(j)));

            }
        }


    }


    public static void showTable(ArrayList<Player> players) {

        String team = "Team";
        char played = 'M';
        char point = 'P';
        char won = 'W';
        char draw = 'D';
        char lost = 'L';
        String goalsFor = "GF";
        String goalsAgainst = "GA";
        String goalsDiffernce = "GD";


        //System.out.println("\n"+BOX1_1);
        System.out.printf("\n%s\n|\t\t\t\t\t\t%10s %3C %3C %4C %3C %3C %5s %3s %3s\t\t\t\t\t\t\t|\n", BOX1_1, team, played, point, won, draw, lost, goalsFor, goalsAgainst, goalsDiffernce);
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("|\t\t\t\t\t\t%10s %3d %3d %4d %3d %3d %5d %3d %3d\t\t\t\t\t\t\t|\n", players.get(i).getName(), players.get(i).getM(), players.get(i).getP(),
                    players.get(i).getW(), players.get(i).getD(), players.get(i).getL(), players.get(i).getGf(), players.get(i).getGa(), players.get(i).getGd());

        }
        System.out.println(BOX1_1);

    }


    public static void newPlayer(Scanner console, ArrayList<Player> players) {
        String newPlayer = "Indtast hold";
        System.out.printf("\n%s\n|\t\t\t\t  %s  \t\t\t\t|\n%s\n", BOX2_1, newPlayer, BOX2_1);
        System.out.print("|\t\t\t\t  ");
        Player player = new Player(console.next(), 0, 0, 0, 0, 0, 0, 0, 0);
        players.add(player);
        System.out.println("Gemt...");
    }

    public static void errorMessage1(String menu1, String menu2) {
        System.out.println("Not valid answer! Try again please!");
        System.out.printf("%s%s\n|\t\t\t%s\t\t\t||\t\t\t%s\t\t\t|\n%s%s", BOX2_1, BOX2_1, menu1, menu2, BOX2_1, BOX2_1);


    }

}
