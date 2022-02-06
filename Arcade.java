/*
Name: Rea Ahuja
Date: January 20th
Program Description: This program represents an arcade that consists of a gaming and store section. The gaming section
consists of two games, and once the user has interacted with the gaming section, they then can enter the store
section which consist of three components, with two mini-games which the user cannot win any points for.
 */

import java.util.*;

/*
Pre: N/A
Description: The gaming class is an abstract class with several abstract methods which will be inherited by all the
games in the gaming section in the arcade.
Post: N/A
 */
abstract class Gaming{
    public Gaming(){};

    abstract void instructions();

    abstract void menu();

    abstract void setPoints(int points);

    abstract int getPoints();

}

/*
Pre: N/A
Description: The store class is an abstract class with several abstract methods which will be inherited by all the store
components in the arcade.
Post: N/A
 */
abstract class Store{
    public Store(){};

    abstract void instructions();

    abstract void menu();

}

/*
Pre: N/A
Description: This class is the arcade class that directs all the functions and executions in the program.
Post: N/A
 */
public class Arcade {
    /*
    Pre: N/A
    Description: The main method is the method that directs the program and the user.
    Post: N/A
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playedStack = false;
        boolean playedLottery = false;
        //user is given introduction
        introduction();

        System.out.println("Welcome to the gaming section!");
        Gaming gameType;
        int stackPoints = 0;
        int lotteryPoints = 0;

        //user enters the gaming section and can choose a game which they want to play
        System.out.println("Below is a menu of a list of games!");
        System.out.println("You can only play each game once, and choose one game at a time!\n");
        int option = gameMenu();

        //while loop is exited if both games are played
        while (option != 3 && (!playedStack || !playedLottery)){
            if (option == 1 && !playedStack){
                //user is redirected to stack in here game
                System.out.println("\nRedirecting to Stack in Here...\n");
                //object is created
                gameType = new StackGame();
                //user is given instructions
                gameType.instructions();
                //user is given menu to play game
                gameType.menu();
                //points earned in game are retrieved
                stackPoints = gameType.getPoints();
                System.out.println("");
                System.out.println("...End of Stack game, welcome back to the main menu");
                //user is told how many points they have won in the game
                System.out.println("You have won " + stackPoints + " through the stack game!");

                playedStack = true;

            }else if (option == 2 && !playedLottery){
                //user is redirected to will you be a millionaire game
                System.out.println("\nRedirecting to Will you be a Millionaire? ...\n");
                //object is created
                gameType = new Millionaire();
                //user is given instructions
                gameType.instructions();
                //user is given menu to play game
                gameType.menu();
                //points earned in game are retrieved
                lotteryPoints = gameType.getPoints();

                playedLottery = true;
            }else{
                //if user inputs anything else then they will be told to input an option again
                System.out.println("Invalid option!");

            }

            if (!playedStack || !playedLottery){
                option = gameMenu();
            }
        }

        //totalPoints are called
        int totalPoints = stackPoints + lotteryPoints;

        System.out.println("You accumulated a total of " + totalPoints + " points!\n");

        //Gaming section is exited and store is entered
        System.out.println("Gaming section has ended!");
        System.out.println("\nWelcome to the Store");
        Store storeComponent;
        boolean saveFile = false;
        boolean buyToy = false;
        boolean seeRank = false;

        System.out.println("Below is a list of options that you can choose from!");
        System.out.println("You can only visit each component once and choose one component at a time!\n");
        int storeOption = storeMenu();

        //while loop is exited if all components are entered
        while (storeOption != 4 && (!saveFile || !buyToy || !seeRank)){
            if (storeOption == 1 && !saveFile){
                //user is redirected to saving file component
                System.out.println("\nRedirecting to saving file component...\n");
                //object is created
                storeComponent = new SaveFile(totalPoints);
                //user is given instructions
                storeComponent.instructions();
                //user is given menu to interact with component
                storeComponent.menu();
                //user is asked if they would like to play mini-game
                firstloadingScreengame();

                saveFile = true;

            }else if (storeOption == 2 && !buyToy){
                //user is redirected to buying toy component
                System.out.println("\nRedirecting to buying toy component...\n");
                //object is created
                storeComponent = new BuyToy(totalPoints);
                //user is given instructions
                storeComponent.instructions();
                //user is given menu to interact with component
                storeComponent.menu();

                buyToy = true;
            }else if (storeOption == 3 && !seeRank){
                //user is redirected to leadership board component
                System.out.println("\nRedirecting to leadership board component...\n");
                //object is created
                storeComponent = new Ranking(totalPoints);
                //user is given instructions
                storeComponent.instructions();
                //user is given menu to interact with component
                storeComponent.menu();
                //user is asked if they would like to play mini-game
                secondloadingScreengame();

                seeRank = true;
            }else{
                //if user does not input a valid option they are shown the following text
                System.out.println("Invalid option!");
            }

            //menu is shown if the user has not visited all the components
            if (!saveFile || !buyToy || !seeRank){
                storeOption = storeMenu();
            }
        }
        System.out.println("\nThe arcade comes to an end!\n");

        System.out.println("Thank you for visiting Rea's arcade! Bye!");



    }

    /*
    Pre: N/A
    Description: User is shown gaming menu and is prompted to enter an option
    Post: The option of which game the user wants to play is returned
     */
    public static int gameMenu(){
        Scanner input = new Scanner(System.in);
        //user is prompted to choose a value from the menu
        System.out.println("\nChoose from menu (1-3):");
        System.out.println("1. Stack in Here");
        System.out.println("2. Will you be a Millionaire?");
        System.out.println("3. Exit gaming section");
        int option = input.nextInt();

        //user's option is returned
        return option;
    }

    /*
    Pre: N/A
    Description: User is shown store menu and is prompted to enter an option
    Post: The option of which store component the user wants to enter is returned
     */
    public static int storeMenu(){
        Scanner input = new Scanner(System.in);
        //user is prompted to choose a value from the menu
        System.out.println("\nChoose from menu (1-4):");
        System.out.println(" 1. Save File");
        System.out.println(" 2. Buy a toy ");
        System.out.println(" 3. Check leadership board");
        System.out.println(" 4. Exit");
        int storeOption = input.nextInt();

        //user's option is returned
        return storeOption;
    }

    /*
    Pre: N/A
    Description: User is given introduction to the arcade
    Post: N/A
     */
    public static void introduction(){
        //user is given introduction to arcade
        System.out.println("Welcome to Rea's Arcade! ");
        System.out.println("This arcade consists of a gaming section and a store!");
        System.out.println("First we will be entering the gaming section and then go to the store");
        System.out.println("Let's begin!\n");
    }

    /*
    Pre: N/A
    Description: User is directed towards the magic sort mini-game if they would like to play
    Post: N/A
     */
    public static void firstloadingScreengame(){
        Scanner input = new Scanner(System.in);
        Store storeGame;
        //user is asked if they would like to play mini-game
        System.out.println("\nAs the file gets processed by the system would you like to play a little game?");
        System.out.println("Note: You will not win any points in it");
        System.out.println("Enter (1) for yes and (2) for no");
        int option = input.nextInt();
        //object is created and the mini-game is played if the user wants to play
        if (option == 1){
            System.out.println("\nRedirecting to magic sort...\n");
            //object is created
            storeGame = new MagicSort();

            //mini-game instructions is showed
            storeGame.instructions();
            //user can interact with main menu
            storeGame.menu();
            System.out.println("\nEnd of game");
            System.out.println("");
        }
    }

    /*
    Pre: N/A
    Description: User is directed towards the magic sort mini-game if they would like to play
    Post: N/A
     */
    public static void secondloadingScreengame(){
        Scanner input = new Scanner(System.in);
        Store storeGame;
        //user is asked if they would like to play mini-game
        System.out.println("\nAs the game redirects back to the main menu would you like to play a little game?");
        System.out.println("Note: You will not win any points in it");
        System.out.println("Enter (1) for yes and (2) for no");
        int option = input.nextInt();
        //object is created and the mini-game is played if the user wants to play
        if (option == 1){
            System.out.println("\nRedirection to message encryptor");
            //object is created
            storeGame = new Encryption();

            //mini-game instructions is showed
            storeGame.instructions();
            //user can interact with main menu
            storeGame.menu();
            System.out.println("\nEnd of game");
            System.out.println("");
        }
    }
}


