import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    StartScreen ss;
    GameScreen gs;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hang Man");
        ss = new StartScreen();
        primaryStage.setScene(new Scene(ss));
        primaryStage.show();
        try {
            ss.getCont().setOnMouseClicked( e -> {
                String userName = ss.getNameBox().getText();
                Controller.setPlayerName(userName);
                String wordToGuess = ss.getPass().getText();
                wordToGuess = wordToGuess.toLowerCase();
                Controller.setToGuess(wordToGuess);
                Controller.setComp();
                gs = new GameScreen();
                primaryStage.setScene(new Scene(gs));
                primaryStage.show();
            });
        } catch (Exception e) {
            System.out.println();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
