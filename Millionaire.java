import java.util.*;

/*
Pre: N/A
Description: The Millionaire class inherits the gaming class as it is a game in the gaming section. Additionally, this
class allows the user to input numbers to create a lottery and then the numbers are compared with the winning lottery.
Post: N/A
 */
public class Millionaire extends Gaming{
    int points;

    /*
    Pre: N/A
    Description: This method is the constructor for the Millionaire class.
    Post: N/A
     */
    public Millionaire(){
        super();
        points = 0;
    }

    /*
    Pre: This method takes the points variable as a parameter
    Description: This method sets the value of points when called on
    Post: N/A
     */
    void setPoints(int points) {
        this.points = points;
    }

    /*
    Pre: N/A
    Description: This method returns the points variable
    Post: This method returns the points variable
     */
    int getPoints() {
        return points;
    }

    /*
    Pre: N/A
    Description: This method provides the instructions for the Millionaire game to the user
    Post: N/A
     */
    void instructions() {
        System.out.println("You will input the numbers between 1-20 to create a lottery");
        System.out.println("The lottery you create will be checked to see if the numbers match the winning lottery");
    }

    /*
    Pre: N/A
    Description: This method directs the user and the main functionalities of the class
    Post: N/A
     */
    void menu() {
        //users lottery is created
        int[][] userNums = createLottery();
        System.out.println("Your lottery: ");
        //users lottery is displayed
        displayArray(userNums);

        System.out.println("Lets check if any numbers match the winning lottery");

        int[][] winNums = {{1, 4, 16, 5},
                           {12, 3, 8, 7}
                          };
        System.out.println("Winning lottery");
        //winning lottery is displayed
        displayArray(winNums);

        int i = 0;
        int j = 0;
        int a = 0;
        int b  = 0;
        int counter = 0;

        //the number of common numbers in both of the arrays is returned
        int sameNums = checkTheNumbers(userNums, winNums, a, b, i, j, counter);

        System.out.println("\nThe lotteries have " + sameNums + " numbers in common!\n");

        //user is awarded points as per the number of numbers they got correct
        if (sameNums < 2){
            points = 100;
        }else if (sameNums < 4){
            points = 200;
        }else if (sameNums < 6){
            points = 300;
        }else if (sameNums < 8){
            points = 400;
        }else{
            points = 1000000;
        }

        //points are set
        setPoints(points);

        System.out.println("Congratulations you won " + points + " points!");
    }

    /*
    Pre: N/A
    Description: This method creates the user's lottery as per the user's input
    Post: The 2D array created is returned
     */
    public int[][] createLottery(){
        Scanner input = new Scanner(System.in);

        int[][] userNums = new int[2][4];

        //userNums which is the user's lottery is filled with numbers
        for (int i = 0; i < userNums.length; i++){
            for (int j = 0; j < userNums[0].length; j++){
                System.out.println("Input a number for row " + i + " and column " + j);
                userNums[i][j] = input.nextInt();

                //if the input is not in between 1-20, then they are prompted to do so
                while (userNums[i][j] < 1 || userNums[i][j] > 20){
                    System.out.println("Invalid input!\nEnter a number between 1-20:");
                    userNums[i][j] = input.nextInt();
                }
            }
        }

        return userNums;
    }

    /*
    Pre: This method takes a 2D array as parameter
    Description: This method prints the 2D array passed to it
    Post: N/A
     */
    public void displayArray(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /*
    Pre: The method takes the user's lottery, the winning lottery, index's for the rows and columns for both arrays
    and a counter as parameters
    Description: This method uses recursion to compare the user's lottery and the winning lottery to find common numbers
    Post: The number of common numbers is returned
     */
    public static int checkTheNumbers(int[][] userNums, int[][] winNums, int a, int b, int i, int j, int counter){
        while (a < userNums.length && b < userNums[0].length){
            //if the numbers being compared are the same the program will enter the following if statement
            if (userNums[a][b] == winNums[i][j]){
                //if the last column has not been reached the following conditional statement will be entered
                if (b < userNums[0].length -1){
                    counter++;
                    i = 0;
                    j = 0;
                    return checkTheNumbers(userNums, winNums, a, b + 1, i, j, counter);
                    //if the last column has been reached the following conditional statement will be entered
                }else if (b == userNums[0].length - 1){
                    b = 0;
                    j = 0;
                    counter++;
                    return checkTheNumbers(userNums, winNums, a + 1, b, i, j, counter);
                }
                //if the numbers being compared are not the same the program will enter the following else statement
            }else{
                //if the last column has not been reached, the following conditional statement will be entered
                if (j < userNums[0].length - 1){
                    return checkTheNumbers(userNums, winNums, a, b, i, j + 1, counter);
                    //if the last column has been reached in the first row the following conditional statement will be entered
                }else if ((j == userNums[0].length - 1) && (i == 0)){
                    j = 0;
                    return checkTheNumbers(userNums, winNums, a, b, i + 1, j, counter);
                    //if the last column and last row has been reached the following conditional statement will be entered
                }else if ((j == userNums[0].length - 1) && (i == 1)){
                    if ((b < userNums[0].length -1)){
                        i = 0;
                        j = 0;
                        return checkTheNumbers(userNums, winNums, a, b + 1, i, j, counter);
                    } else if (b == userNums[0].length -1){
                        b = 0;
                        i = 0;
                        j = 0;
                        return checkTheNumbers(userNums, winNums, a + 1, b, i, j, counter);
                    }

                }
            }
        }

        //the number of common numbers are returned
        return counter;
    }

}
