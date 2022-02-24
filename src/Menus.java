public class Menus {

    Buttons buttons = new Buttons("", "", "");

        public String welcomeText(String INTROTEXT){
        String BOX1_1 = " ------------------------------------------------------------------------------------------------";
        String BOX1_2 = "|                                                                                                |";

        return String.format("%s\n%s\n|\t\t\t\t\t\t\t\t%35s\t\t\t\t\t\t\t\t |\n%s\n%s\n", BOX1_1, BOX1_2, INTROTEXT, BOX1_2, BOX1_1);

    }
    public String menu1 (String menu1,String menu2 ){
         return buttons.dobbleButton(menu1, menu2);
    }



}
