public class Buttons {

    //vi skal have stor knap og lille knap

    private String margeTop;
    private String margeCenter;
    private String margeBottom;

    public Buttons(String marge1, String marge2, String text) {
        this.margeTop = marge1;
        this.margeCenter = marge2;
        this.margeBottom = text;
    }

    public String bigButton() {
        margeTop = " ------------------------------------------------------------------------------------------------ ";
        margeCenter = centerString(96, "hello world!");
        margeBottom = " ------------------------------------------------------------------------------------------------ ";
        return (margeTop + "\n" + margeCenter + "\n" + margeBottom);
    }

    public String dobbleButton() {
        margeTop = " ----------------------------------------------- ";
        margeCenter = centerString(47, "hello world!");
        String margeCenter2 = centerString(47, "hello world!2");
        margeBottom = " ----------------------------------------------- ";
        return (margeTop + margeTop + "\n" + margeCenter + margeCenter2 + "\n" + margeBottom + margeBottom);

    }


    public String smallButton() {
        margeTop = " ----------------------------------------------- ";
        margeCenter = centerString(47, "hello world!");
        margeBottom = " ----------------------------------------------- ";
        return (margeTop + "\n" + margeCenter + "\n" + margeBottom);

    }

    public static String centerString(int width, String s) {
        return String.format("|%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s)) + "|";
    }

    public String getMargeTop() {
        return margeTop;
    }

    public void setMargeTop(String margeTop) {
        this.margeTop = margeTop;
    }

    public String getMargeCenter() {
        return margeCenter;
    }

    public void setMargeCenter(String margeCenter) {
        this.margeCenter = margeCenter;
    }

    public String getMargeBottom() {
        return margeBottom;
    }

    public void setMargeBottom(String margeBottom) {
        this.margeBottom = margeBottom;
    }
}

/*
    public Buttons buttonsBuilder(Scanner scan){
        //get y, x
        System.out.println("Insert side a");
        int x = getSide(scan);
        System.out.println("Insert side b");
        int y = getSide(scan);
        String horsintalLines = "-----------------------------------------------------------------------------------------------------";
        String a = String.format("%xs",horsintalLines);
        String verticalLines = "|";
        String b = String.format("%ys", verticalLines);

        Buttons button = new Buttons(a,b, "");
        return button;

    }
    public int getSide(Scanner scan){
        int side = scan.nextInt();
        return side;
    }
}*/
