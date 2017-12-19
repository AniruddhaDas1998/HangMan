import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

/**
 * Created by aniruddhadas on 14/02/17.
 */
public class GameScreen extends BorderPane {
    private static HBox leftOptions = new HBox(10);
    private static ImageView hangStat;
    public GameScreen() {
            String s = "Characters not chosen are: " + updateS();
            Image image = new Image("File:../HangStages/Stage 0.png");
            hangStat = new ImageView();
            hangStat.setImage(image);
            Label l = new Label(s);
            leftOptions.getChildren().setAll(l);
            this.setTop(leftOptions);
            this.setRight(hangStat);
            this.setCenter(PlayScreen.getInstance());
            PlayScreen.getInstance().getSubmit().setOnMouseClicked( e -> {
                String guess = PlayScreen.getInstance().getGuessBox().getText();
                guess = guess.toLowerCase();
                if (guess.equals(Controller.getToGuess())) {
                    PlayScreen.getInstance().update();
                    Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                    newAlert.setHeaderText("Congratulations " + Controller.getPlayerName()
                            + "!! You have won!! :D");
                    newAlert.setTitle("Hurray!!");
                    newAlert.showAndWait();
                    System.exit(0);
                }
                char choice = '\0';
                if (guess.length() != 0) {
                    choice = guess.charAt(0);
                }
                Controller.play(choice);
                PlayScreen.getInstance().update();
                PlayScreen.getInstance().getGuessBox().setText("");
            });
    }

    public static ImageView getHangStat() {
        return hangStat;
    }

    private static String updateS() {
        String s = "";
        for (int i = 0; i < Controller.LETS.length; i ++) {
            if ((i == Controller.LETS.length - 1) && Controller.LETS[i] != ' ') {
                s += Controller.LETS[i];
            } else if (Controller.LETS[i] != ' ') {
                s += Controller.LETS[i] + ", ";
            }
        }
        return s;
    }

    public static void updateHBox() {
        String s = "Characters not chosen are: " + updateS();
        leftOptions.getChildren().setAll(new Label(s));
    }
}
