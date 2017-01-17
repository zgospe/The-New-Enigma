import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Scanner;

/**
 * Machine to create and decipher
 * new enigma code.
 * Created by Zach and Chris on 1/17/17.
 * This is legacy code - never change it.
 */
public class NewEnigma {

    public static void main (String[] args){

        System.out.print("Would you like to encode or decipher text? E/D: ");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        // consume nextLine character
        input.nextLine();
        String solution = "";
        if (answer.toLowerCase().equals("e")) {
            System.out.print("Please enter text to be translated: ");
            String text = input.nextLine();
            encode(text);
        } else if (answer.toLowerCase().equals("d")) {
            System.out.print("Please enter text to be translated: ");
            String text = input.nextLine();
            decode(text);
        } else {
            System.out.println("Please enter either e or d!");
            main(null);
        }
    }
    public static void encode (String text) {
        char[] sequence = text.toCharArray();
        int counter = 1;
        int place = 1;
        boolean upper = false;
        for (char c : sequence) {
            if (Character.isLetter(c)) {
                upper = (Character.isUpperCase(c));
                char temp = Character.toLowerCase(c);
                temp = (char) (temp - 97);
                temp = (char) ((temp + counter) % 26);
                temp = (char) (temp + 97);
                if (upper) {
                    temp = (char) (temp - 32);
                }
                sequence[place - 1] = temp;
                counter++;
            }
            System.out.print(sequence[place - 1]);
            place++;
        }
    }

    public static void decode (String text) {
        char[] sequence = text.toCharArray();
        int counter = 25;
        int place = 1;
        boolean upper = false;
        for (char c : sequence) {
            if (Character.isLetter(c)) {
                upper = (Character.isUpperCase(c));
                char temp = Character.toLowerCase(c);
                temp = (char) (temp - 97);
                temp = (char) ((temp + counter) % 26);
                temp = (char) (temp + 97);
                if (upper) {
                    temp = (char) (temp - 32);
                }
                sequence[place - 1] = temp;
                counter--;
                if (counter == -1) {
                    counter = 25;
                }
            }
            System.out.print(sequence[place - 1]);
            place++;
        }
    }
}
