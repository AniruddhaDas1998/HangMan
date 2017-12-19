import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    static char[] LETS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z'};

    private static int numGuess = 0;
    private static String playerName;
    private static String toGuess;

    static char comp[];

    private static boolean contains(char check) {
        for (int i = 0; i < Controller.getToGuess().length(); i++) {
            if (Controller.getToGuess().charAt(i) == check) {
                return true;
            }
        }
        return false;
    }

    public static void setComp() {
        comp = new char[toGuess.length()];
        for (int i = 0; i < toGuess.length(); i++) {
            comp[i] = '_';
        }
    }

    private static void modString(char c, char[] ch) {
        for (int i = 0; i < Controller.getToGuess().length(); i++) {
            if (Controller.getToGuess().charAt(i) == c) {
                ch[i] = c;
            }
        }
    }

    public static void play(char ch) {
        try {
            char guess = ch;
            if (LETS[((int) (guess)) % 97] == ' ') {
                Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                newAlert.setHeaderText("You have already tried this :(");
                newAlert.setTitle("Oops!");
                newAlert.showAndWait();
                return;
            }
            if (!contains(guess)) {
                numGuess++;
            }
            modString(guess, comp);
            int ind = ((int) (guess)) % 97;
            LETS[ind] = ' ';
            GameScreen.updateHBox();
            display(numGuess);
            if ((new String(comp)).equalsIgnoreCase(Controller.getToGuess())) {
                PlayScreen.getInstance().update();
                Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                newAlert.setHeaderText("Congratulations " + playerName + "!! You have won!! :D");
                newAlert.setTitle("Hurray!!");
                newAlert.showAndWait();
                System.exit(0);
            }
        } catch (Exception e) {
            Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
            newAlert.setHeaderText("Input Mismatch :(");
            newAlert.setTitle("Oops!");
            newAlert.showAndWait();
        }
    }

    private static void display(int numGuess) {
        switch (numGuess) {
            case 0:
                break;
            case 1:
                Image image0 = new Image("File:../HangStages/Stage 1.png");
                GameScreen.getHangStat().setImage(image0);
                break;
            case 2:
                Image image1 = new Image("File:../HangStages/Stage 2.png");
                GameScreen.getHangStat().setImage(image1);
                break;
            case 3:
                Image image2 = new Image("File:../HangStages/Stage 3.png");
                GameScreen.getHangStat().setImage(image2);
                break;
            case 4:
                Image image3 = new Image("File:../HangStages/Stage 4.png");
                GameScreen.getHangStat().setImage(image3);
                break;
            case 5:
                Image image4 = new Image("File:../HangStages/Stage 5.png");
                GameScreen.getHangStat().setImage(image4);
                break;
            case 6:
                Image image5 = new Image("File:../HangStages/Stage 6.png");
                GameScreen.getHangStat().setImage(image5);
                break;
            case 7:
                Image image6 = new Image("File:../HangStages/Stage 7.png");
                GameScreen.getHangStat().setImage(image6);
                break;
            case 8:
                Image image7 = new Image("File:../HangStages/Stage 8.png");
                GameScreen.getHangStat().setImage(image7);
                break;
            case 9:
                Image image8 = new Image("File:../HangStages/Stage 9.png");
                GameScreen.getHangStat().setImage(image8);
                break;
            case 10:
                Image image9 = new Image("File:../HangStages/Stage 10.png");
                GameScreen.getHangStat().setImage(image9);
                Alert warnAlert = new Alert(Alert.AlertType.INFORMATION);
                warnAlert.setHeaderText("Uh oh!! Last chance!! :O");
                warnAlert.setTitle("Oops!");
                warnAlert.showAndWait();
                break;
            case 11:
                Image image = new Image("File:../HangStages/Stage 11.png");
                GameScreen.getHangStat().setImage(image);
                Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                newAlert.setHeaderText("You have lost. RIP :("
                    + " \nThe word was: " + toGuess.toUpperCase());
                newAlert.setTitle("Oops!");
                newAlert.showAndWait();
                System.exit(0);
                break;
        }
    }

    public static String getComp() {
        return new String(comp);
    }

    public static void setPlayerName(String name) {
        playerName = name;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setToGuess(String toSetGuess) {
        toGuess = toSetGuess;
    }

    public static String getToGuess() {
        return toGuess;
    }
}
