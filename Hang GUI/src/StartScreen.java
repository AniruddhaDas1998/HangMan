import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

/**
 * Created by aniruddhadas on 13/02/17.
 */
public class StartScreen extends StackPane {
    private Label intro;
    private TextField nameBox;
    private Button cont;
    private PasswordField pass;
    public StartScreen() {
        Image image = new Image("File:../StartScreen/hangu.png");
        ImageView iv = new ImageView();
        iv.setImage(image);
        this.getChildren().add(iv);
        Label exp = new Label("HANGMAN");
        exp.setTextFill(Color.ORANGERED);
        exp.setTranslateY(-200.0);
        exp.setTranslateX(40.0);
        exp.setFont(new Font(60.0));
        this.getChildren().add(exp);
        intro = new Label("Welcome! ");
        intro.setTextFill(Color.ORANGERED);
        intro.setFont(new Font(30.0));
        intro.setTranslateX(0.0);
        intro.setTranslateY(30.0);
        nameBox = new TextField("Enter your name here..");
        nameBox.setMaxWidth(200.0);
        nameBox.setTranslateX(-10.0);
        nameBox.setTranslateY(60.0);
        this.getChildren().addAll(intro, nameBox);
        cont = new Button("Press to Continue");
        cont.setTranslateY(120.0);
        cont.setTranslateX(0.0);
        this.getChildren().add(cont);
        pass = new PasswordField();
        pass.setMaxWidth(200.0);
        pass.setTranslateY(90.0);
        pass.setTranslateX(-10.0);
        this.getChildren().add(pass);
    }
    public Button getCont() {
        return cont;
    }
    public TextField getNameBox() {
        return nameBox;
    }
    public PasswordField getPass() {
        return pass;
    }
}
