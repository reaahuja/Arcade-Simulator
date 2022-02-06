import java.util.*;

/*
Pre: N/A
Description: The BuyToy class inherits the store class as well as the methods that it contained. Additionally, in this
class the program will take a look at how many points the user has and accordingly give a prize.
Post: N/A
 */
public class BuyToy extends Store {
    int points;

    /*
    Pre: N/A
    Description: This method is the constructor for the BuyToy class
    Post: N/A
     */
    public BuyToy() {
        super();
        points = 0;
    }

    /*
    Pre: This method takes the total number of points that the user has won as a parameter
    Description: This method is the parametrized constructor for the BuyToy class
    Post: N/A
     */
    public BuyToy(int totalPoints) {
        this.points = totalPoints;
    }

    /*
    Pre: N/A
    Description: This method gives the instructions on how to interact with the BuyToy class methods
    Post: N/A
     */
    void instructions() {
        System.out.println("The program will analyze the number of points that you have earned");
        System.out.println("Your points will be compared to the points card and you will be given an according toy");
    }

    /*
    Pre: N/A
    Description: This method directs the user and the main functionalities of the class
    Post: N/A
     */
    void menu() {
        int[] toyIndex = new int[32];
        int number = 0;

        //points card (toyIndex array) is filled with numbers
        for (int i = 0; i < 21; i++){
            toyIndex[i] = number;
            number += 100;
        }

        toyIndex[21] = 1000000;

        int numberFilling = 1000000;

        //if user won lottery and has also won points in stack game
        for (int i = 22; i < 32; i++){
            toyIndex[i] = numberFilling;
            numberFilling += 100;
        }

        //binary search is used to find the index of the points along the toyIndex array
        int beginning = 0;
        int end = toyIndex.length - 1;
        int middle = (beginning + end)/2;

        //binary search is performed
        while (beginning <= end){
            if (toyIndex[middle] < points){
                //if toyIndex[middle] is less than points, than the range is shortened by changing the value of the beginning variable
                beginning = middle + 1;
            }else if (toyIndex[middle] > points){
                //if toyIndex[middle] is greater than the points, then the range is shortened by changing the value of the end variable
                end = middle - 1;
            }else if (toyIndex[middle] == points){
                //if toyIndex[middle] is equal to the points then the break function is used to exit the while loop
                break;
            }

            middle = (beginning + end)/2;
        }

        System.out.println("The index along the points card is: " + middle);

        String awardToy = assignToy(middle);

        //awarded prize is printed to console
        System.out.println(awardToy);


    }

    /*
    Pre: This method takes the index variable as a parameter
    Description: This method decides which toy should be awarded to the user depending on the index of their points
    along the toyIndex array
    Post: This method returns the string that consists of the toys that the user has won
     */
    public String assignToy(int index){
        Random random = new Random();
        int number = random.nextInt(4);
        String toy = "";

        //depending on index, user gets a random toy from the according toy array/arrays
        String[] toy1 = {"pencil", "eraser", "lead container", " bracelet"};
        String[] toy2 = {"notebook", "pencil case", "binder", "agenda"};
        String[] toy3 = {"calculator", "water bottle", "lunch box", "phone case"};
        String[] toy4 = {"backpack", "jacket", "umbrella", "suitcase"};
        String[] toy5 = {"Graphing calculator", "Arduino board", "Texas instrument microcontroller", "microcontroller components"};
        String[] toy6 = {"3D printer", "laser printer", "ink printer", "iPhone"};

        //random prize from toy arrays is printed to the console depending on index
        //the more points the user has won the more and better awards they getF
        if (index < 5){
            toy = "You won a " + toy1[number];
        }else if (index < 10){
            toy = "You won a " + toy1[number] + " and a " + toy2[number];
        }else if (index < 15){
            toy = "You won a " + toy1[number] + ", " + toy2[number] + " and a " + toy3[number];
        }else if (index < 20){
            toy = "You won a " + toy1[number] + ", " + toy2[number] + ", " + toy3[number] + " and a " + toy4[number];
        }else if (index < 21){
            toy = "You won a " + toy5[number];
        }else{
            toy = "You won a " + toy5[number] + " and a " + toy6[number];
        }

        //string with toy is returned to menu method
        return toy;

    }

}