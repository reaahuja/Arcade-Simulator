import java.util.*;
import java.util.Stack;

/*
Pre: N/A
Description: The Encryption class inherits the store, as it is a mini-game in the store. Additionally, this class allows
the user to input an encrypted message, and the program will decrypt it from them.
Post: N/A
 */
public class Encryption extends Store{
    /*
    Pre: N/A
    Description: This method provides the instructions for the Encryption game to the user
    Post: N/A
     */
    void instructions() {
        System.out.println("In this game you can input an encrypted message and the program will decrypt it!");
        System.out.println("The encrypted message should look like letters in brackets surrounded by a number");
        System.out.println("For example 3[b2[ca]] " );
        System.out.println("Additionally this will produce bcacabcacabcaca");
        System.out.println("Have fun!\n");
    }

    /*
   Pre: N/A
   Description: This method directs the user and the main functionalities of the class
   Post: N/A
    */
    void menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("To play enter (1) to exit enter (2)");
        int option = input.nextInt();

        //if user inputs 1 then the program enters the following while statement
        while (option != 2){
            System.out.println("Input an encryption");
            String message = input.next();

            Stack<Character> stack = new Stack<>();

            //characters that are not '[' or ']' will be pushed into the stack
            for (int i = 0; i < message.length(); i++){
                if (!(message.charAt(i) == '[' )&& !(message.charAt(i) == ']')){
                    stack.push(message.charAt(i));
                }
            }


            String answer = "";
            //program will repeat while loop while stack is not empty
            while (!stack.isEmpty()){
                char element = stack.lastElement();
                boolean aNumber = isNumber(stack.lastElement());
                //if the character is a number then the characters will be duplicated as per the number
                if (aNumber == true){
                    int number = Integer.parseInt(String.valueOf(element));
                    String value = answer;
                    answer = "";
                    for (int i = 0; i < number; i++){
                        answer += value;
                    }
                }else{
                    //if the character is not a number it will be added to the answer
                    answer = element + answer;
                }
                stack.pop();
            }

            //message is displayed
            System.out.println("Decrypted message is: " + answer);
            System.out.println("To play enter (1) to exist enter (2)");
            option = input.nextInt();
        }


    }

    /*
    Pre: This method takes the element that the program is analyzing as a parameter
    Description: This method checks if the analyzed value is an integer or not
    Post: The boolean value true or false is returned
     */
    public static boolean isNumber(char element){
        try{
            Integer.parseInt(String.valueOf(element));
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
