import modles.Match;
import modles.MatchPlayed;
import modles.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramBody {

    static Scanner console = new Scanner(System.in);

    static Buttons buttons = new Buttons("","","");

    static ArrayList<Player> players = new ArrayList<>();

    static ArrayList<Match> unplayedMatches = new ArrayList<>();

    static ArrayList<MatchPlayed> playedMatches = new ArrayList<>();

    public static void newPlayer() {
        String newPlayer = "Indtast hold";
        System.out.println(buttons.smallButton(newPlayer));
        //System.out.printf("\n%s\n|\t\t\t\t  %s  \t\t\t\t|\n%s\n", BOX2_1, newPlayer, BOX2_1);
        System.out.print("|\t\t\t\t  ");
        Player player = new Player(console.next(), 0, 0, 0, 0, 0, 0, 0, 0);
        players.add(player);
        System.out.println("Gemt...");
    }

    public static void save(ArrayList<Player> players) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Table.txt"));
        for (int i = 0; i < players.size(); i++) {
            output.printf("%10s %3d %3d %4d %3d %3d %5d %3d %3d\n", players.get(i).getName(), players.get(i).getM(),
                    players.get(i).getP(),
                    players.get(i).getW(), players.get(i).getD(), players.get(i).getL(), players.get(i).getGf(),
                    players.get(i).getGa(), players.get(i).getGd());
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
        System.out.printf("\n%s\n|\t\t\t\t\t\t%10s %3C %3C %4C %3C %3C %5s %3s %3s\t\t\t\t\t\t\t|\n", Version1.BOX1_1, team, played, point, won, draw, lost, goalsFor, goalsAgainst, goalsDiffernce);
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("|\t\t\t\t\t\t%10s %3d %3d %4d %3d %3d %5d %3d %3d\t\t\t\t\t\t\t|\n", players.get(i).getName(), players.get(i).getM(), players.get(i).getP(),
                    players.get(i).getW(), players.get(i).getD(), players.get(i).getL(), players.get(i).getGf(), players.get(i).getGa(), players.get(i).getGd());

        }
        System.out.println(Version1.BOX1_1);

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

    public static void selectMatch(ArrayList<Match> unplayedMatches, ArrayList<MatchPlayed> playedMatches, Scanner scan, ArrayList<Player> players) throws FileNotFoundException {
        /*System.out.println(BOX2_1);
        for (int i = 0; i < unplayedMatches.size(); i++) {
            System.out.println("|\t "+(i + 1) + "\t\t" + unplayedMatches.get(i)+"\t\t\t|");
            System.out.println(BOX2_1);
        }*/

        for (int i = 0; i < unplayedMatches.size(); i++) {
            String match = (i + 1)+"\t" + unplayedMatches.get(i);
            System.out.println(buttons.smallButton(match));
        }
            //System.out.println(BOX2_1);
        String chooseGame = "Choose match";
        //System.out.printf("\n%s\n|\t\t\t\t  %s  \t\t\t\t|\n%s", BOX2_1, chooseGame, BOX2_1);
        System.out.println(buttons.smallButton(chooseGame));
        //make a robustance
        int index = scan.nextInt();
        registrateMatch(index, unplayedMatches, playedMatches, scan, players);
    }

    public static void registrateMatch(int i, ArrayList<Match> unplayed, ArrayList<MatchPlayed> playedMatches, Scanner scan, ArrayList<Player> players) throws FileNotFoundException {

        //needs a senital loop to condition when to exit

        String resultWhat = "What is the result?";
        //System.out.printf("%s\n|\t\t\t %20s \t\t %-10s vs. %10s", BOX1_1, resultWhat, unplayed.get(i - 1).getPlayer1(), unplayed.get(i - 1).getPlayer2());
        System.out.println(buttons.bigButton(resultWhat));

        System.out.print("\n|\t"+unplayed.get(i - 1).getPlayer1() + ":_");
        int res1 = scan.nextInt();
        System.out.print("|\t"+unplayed.get(i - 1).getPlayer2() + ":_");
        int res2 = scan.nextInt();
        //System.out.println(BOX1_1);

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
        savePlayedMatches(playedMatches);
        //saveComming(unplayed);

        showPlayedMatched(playedMatches);
        showTable(players);
        selectMatch(unplayed, playedMatches, scan, players);
    }

    public static void savePlayedMatches(ArrayList<MatchPlayed> played)throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("Played.txt"));
        for (int i = 0; i < played.size(); i++){
            output.println(played.get(i));
        }
    }

    public static void showPlayedMatched(ArrayList<MatchPlayed> playedMatches) {
        //System.out.println(BOX2_1);
        for (int i = 0; i < playedMatches.size(); i++) {
            //System.out.printf("|\t\t %s \t\t\t|\n", playedMatches.get(i));
            String playedMatchesToString = ""+playedMatches.get(i);
            System.out.println(buttons.smallButton(playedMatchesToString));
        }
        //System.out.print(BOX2_1);
    }



    public void createNewTournament() throws FileNotFoundException {

        String confirm = ("Er du sikker? Gamle data vil blive tabt - press 1");

        System.out.print(confirm);

        while (!console.hasNextInt() /*|| console.nextInt() !=1 || console.nextInt() !=2*/) {
            console.next(); //to discard the input
            System.out.println("Not valid answer! Try again please!");
            System.out.print(confirm);
        }

        switch (console.nextInt()){
            case 1: System.out.println("Confirmed");
            newPlayer();
            do {
                newPlayer();
                System.out.println(buttons.dobbleButton(Main.MENU3, Main.MENU4));
                //System.out.printf("%s%s\n|\t\t\t%s\t\t\t||\t\t\t%s\t\t|\n%s%s", BOX2_1, BOX2_1, Main2.MENU3, menu4, BOX2_1, BOX2_1);
                while (!console.hasNextInt() /*|| console.nextInt() !=1 || console.nextInt() !=2*/) {
                    console.next(); //to discard the input
                    System.out.println("Not valid answer! Try again please!");
                }
                save(players);

            } while (console.nextInt() == 1);

                showTable(players);
                makeMatches(players, unplayedMatches);
                selectMatch(unplayedMatches, playedMatches, console, players);

                /*/Tuneringen starter her
            saveComming(unplayedMatches);

            //registrateResult();*/

            case 2: loadExistingTournament();

        }
    }

    public static void readNames() throws FileNotFoundException {
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

            players.add(new Player(name, 0, 0, 0, 0, 0, 0, 0, 0));

        }
    }

    public static void readPlayedMatches() throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("Played.txt"));

        /*
        den macher navnene med dem i tabelen
	hvis navn a macther med et navn fra arraylisten
	så sæt sæt navnet med objectet fra arraylisten
	indlæs object a mål score

	indlæs object b mål score
	mach navn b med object fra arraylisten
	oprette et færdispillet resultat og
		opdatere objecterne og tabellet
         */
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);

            String playerA = lineScan.next();
            int k = 0;
            int l = 0;
            int aScore = 0;


            for (int i = 0; i < players.size(); i++){
                if (players.get(i).getName().equalsIgnoreCase(playerA)){
                    aScore = lineScan.nextInt();
                    k = i;
                    break;
                }
            }
            lineScan.next();
            int bScore = lineScan.nextInt();
            String playerB = lineScan.next();
            for (int j = 0; j < players.size(); j++){
                if (players.get(j).getName().equalsIgnoreCase(playerB)){
                    l = j;
                    break;

                    //selectMatch(unplayedMatches, playedMatches, console, players);
                    //registrateMatch(p, playedMatches, players);
                }
            }
            //registrateMatch();

            MatchPlayed matchPlayed = new MatchPlayed(players.get(k), players.get(l), aScore, bScore);
            playedMatches.add(matchPlayed);

        }



    }

    public void loadExistingTournament() throws FileNotFoundException {
        //først skal den læse fra filen for at oprette nulstillede objecter af spillerne
        //og add dem til arraylist

        makeMatches(players, unplayedMatches);
        readNames();
        readPlayedMatches();
        showPlayedMatched(playedMatches);
        showTable(players);
        selectMatch(unplayedMatches, playedMatches, console, players);//show matches
        //makeMatches(players, unplayedMatches);



    }
}
