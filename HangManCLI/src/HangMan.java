import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Console;
import java.io.IOException;

public class HangMan {
    private static String word;
    char[] LETS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
         'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
             'x', 'y', 'z'};
    private int numGuess = 0;

    private boolean contains(char check) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == check) {
                return true;
            }
        }
        return false;
    }

    private void display(int nDisp) {
        if (nDisp == 0) {
            System.out.println(" Good going. All lives left!");
        }
        if (nDisp == 1) {
            System.out.println("\n __");
        } else if (nDisp == 2) {
            System.out.println("\n |");
            System.out.println(" |");
            System.out.println("___");
        } else if (nDisp == 3) {
            System.out.println("\n |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println("___");
        } else if (nDisp == 4) {
            System.out.println("\n |---");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println("___");
        } else if (nDisp == 5) {
            System.out.println("\n |---");
            System.out.println(" |   |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println("___");
        } else if (nDisp == 6) {
            System.out.println("\n |---");
            System.out.println(" |   |");
            System.out.println(" |   0");
            System.out.println(" |");
            System.out.println("___");
        } else if (nDisp == 7) {
            System.out.println("\n |---");
            System.out.println(" |   |");
            System.out.println(" |   0");
            System.out.println(" |   |");
            System.out.println("___");
        } else if (nDisp == 8) {
            System.out.println("\n |---");
            System.out.println(" |   |");
            System.out.println(" |   0");
            System.out.println(" |   |");
            System.out.println("___   \\");
        } else if (nDisp == 9) {
            System.out.println("\n |---");
            System.out.println(" |   |");
            System.out.println(" |   0");
            System.out.println(" |   |");
            System.out.println("___  /\\");
        } else if (nDisp == 10) {
            System.out.println("\n |---");
            System.out.println(" |   |");
            System.out.println(" |   0");
            System.out.println(" |   |\\");
            System.out.println("___  /\\");
        } else if (nDisp == 11) {
            System.out.println("You have lost! ");
            System.out.println("\n |---");
            System.out.println(" |   |");
            System.out.println(" |   0");
            System.out.println(" |  /|\\");
            System.out.println("___  /\\");
            System.out.println("The word was: " + word);
            System.exit(0);
        }
    }

    private void play() throws IOException {
        char comp[] = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            comp[i] = '_';
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (numGuess <= 10) {
            try {
                System.out.println("\nEnter a guess");
                String in = br.readLine();
                in = in.toLowerCase();
                char guess = in.charAt(0);
                if (LETS[((int) (guess)) % 97] == ' ') {
                    System.out.println("Input already chosen before! ");
                    continue;
                }
                if (!contains(guess)) {
                    numGuess++;
                }
                System.out.print("The current word is: ");
                displayString(guess, comp);
                int ind = ((int) (guess)) % 97;
                LETS[ind] = ' ';
                System.out.println("Letters you have not tried are: ");
                for (char c : LETS) {
                    if (c != ' ') {
                        System.out.print(c + ", ");
                    }
                }
                display(numGuess);
                if ((new String(comp)).equalsIgnoreCase(word)) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("Exception thrown"
                    + " likely cause is due to input mismatch");
            }
        }
    }

    private void displayString(char c, char[] ch) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                ch[i] = c;
            }
            System.out.print(ch[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) throws IOException {
        Console console = System.console();
        System.out.println("Welcome! Lets play HangMan!");
        System.out.println("What is your name?");
        String name = console.readLine();
        System.out.print("Please enter the word to be guessed: ");
        char[] passwordChars = console.readPassword();
        word = new String(passwordChars);
        word = word.toLowerCase();
        HangMan obj = new HangMan();
        System.out.println("Word inputted. Let's play!");
        obj.play();
        System.out.println("\n Congratulations " + name + " you have won!");
    }
}