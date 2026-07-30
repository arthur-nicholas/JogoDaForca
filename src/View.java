
import java.util.ArrayList;

public class View {
    int numberOfTry;
    String word;
    String category;
    ArrayList<Character> usedLetters = new ArrayList<Character>();

    public View(int numberOfTry, String word, String category){
        this.numberOfTry = numberOfTry;
        this.word = word;
        this.category = category;

    }

    public void viewDraw(char[] wordToComplete){
        System.out.println("__________________________________________________________________________");
        System.out.println("   ================                                                       ");
        System.out.println("   ||             |           Categoria: "+category+"                     ");
        System.out.println("   ||            ( )          Letras usadas: "+usedLetters+"              ");
        System.out.println("   ||                         Tentativas disponiveis: "+numberOfTry+"     ");
        System.out.println("   ||                                                                     ");
        System.out.println("   ||         "+String.valueOf(wordToComplete)+"                          ");
        System.out.println(" __||__                                                                   ");
        System.out.println("__________________________________________________________________________");
    }

    public void decreaseNumberOfTry(){
        this.numberOfTry--;
    }

    public void updateUsedLetters(char newLetter){
        if(!usedLetters.contains(newLetter)){
            usedLetters.add(newLetter);
        }
    }
}

