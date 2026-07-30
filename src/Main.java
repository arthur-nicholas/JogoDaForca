import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

class Main{
    public static void main() throws IOException, URISyntaxException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Word word = new Word();
        String newWord = word.newWord;
        String category = word.category;
        View view = new View(5, newWord, category);

        char[] wordToComplete = new char[newWord.length()];
        for (int i = 0; i < wordToComplete.length ; i++) {
            if(newWord.charAt(i) == ' '){
                wordToComplete[i] = ' ';
                return;
            }
            if(newWord.charAt(i) == '-'){
                wordToComplete[i] = '-';
                return;
            }
            wordToComplete[i] = '_';
        }

        boolean closeView = false;

         do{
            view.viewDraw(wordToComplete);
            System.out.print("Insira uma letra: ");
            char letter = scanner.next().charAt(0);

            boolean isRight = compare(newWord, letter, wordToComplete);
            closeView = verify(view,letter,wordToComplete,isRight);
        } while(!closeView);
         scanner.close();
    }

    static boolean compare(String word, char letter,char[] wordToComplete){
        boolean isRight = false;
        for (int i = 0; i < word.length(); i++) {
            if(letterWithAccent(word,letter,wordToComplete,i)){
                isRight = true;
            }
            else if (word.charAt(i) == letter && wordToComplete[i] != letter) {
                wordToComplete[i] = letter;
                isRight = true;
            }
        }
        return isRight;
    }

    static boolean letterWithAccent(String word,char letter,char[] wordToComplete,int index){
        if(word.charAt(index) == 'ã' && letter == 'a' && wordToComplete[index] != letter){
            wordToComplete[index] = 'ã';
            return true;
        }
        if(word.charAt(index) == 'â' && letter == 'a' && wordToComplete[index] != letter){
            wordToComplete[index] = 'â';
            return true;
        }
        if(word.charAt(index) == 'ç' && letter == 'c' && wordToComplete[index] != letter){
            wordToComplete[index] = 'ç';
            return true;
        }
        if(word.charAt(index) == 'õ' && letter == 'o' && wordToComplete[index] != letter){
            wordToComplete[index] = 'õ';
            return true;
        }
        if(word.charAt(index) == 'ô' && letter == 'o' && wordToComplete[index] != letter){
            wordToComplete[index] = 'ô';
            return true;
        }
        return false;
    }

    static boolean verify(View view,char letter, char[] wordToComplete , boolean isRight){
        view.updateUsedLetters(letter);
        if(!isRight){
            view.decreaseNumberOfTry();
            if(view.numberOfTry == 0){
                System.out.println("Que pena, voce errou. A palavra era: "+view.word);
                return true;
            }
        }

        if(view.word.equals(String.valueOf(wordToComplete))){
            System.out.println("è igual. Voce acertou!!!");
            return true;
        }
        return false;
    }
}


