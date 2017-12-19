import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Created by aniruddhadas on 14/02/17.
 */
public class PlayScreen extends StackPane {
    private static PlayScreen ps = new PlayScreen();
    private TextField guessBox;
    private Button submit;
    private Label promWord;

    static PlayScreen getInstance() {
        return ps;
    }

    private PlayScreen() {
        Image image = new Image("File:../StartScreen/hangu.png");
        ImageView iv = new ImageView();
        iv.setImage(image);
        this.getChildren().add(iv);
        promWord = new Label(Controller.getComp());
        promWord.setFont(new Font(36.0));
        promWord.setTextFill(Color.ORANGERED);
        Label prompt = new Label("Enter a guess");
        prompt.setFont(new Font(32.0));
        prompt.setTextFill(Color.ORANGERED);
        prompt.setTranslateX(-15.0);
        prompt.setTranslateY(40.0);
        guessBox = new TextField("Enter your guess here..");
        guessBox.setMaxWidth(200.0);
        guessBox.setTranslateX(-15.0);
        guessBox.setTranslateY(70.0);
        submit = new Button("Submit");
        submit.setTranslateY(100.0);
        this.getChildren().addAll(promWord, prompt, guessBox, submit);
    }

    public void update() {
        promWord.setText(new String(Controller.comp));
    }

    public Button getSubmit() {
        return submit;
    }

    public TextField getGuessBox() {
        return guessBox;
    }

    public Label getPromWord() {
        return promWord;
    }
}
